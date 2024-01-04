package com.example.project.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.project.DataModel.Item
import com.example.project.DataModel.Review
import com.example.project.DetailActivity
import com.example.project.R

class ItemAdapter(val context: Context, val itemList: MutableList<Item>, val path: String?) : RecyclerView.Adapter<ItemAdapter.MyViewHolder>(){
    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val itemName: TextView = itemview.findViewById(R.id.item_name)
        val itemImage: ImageView = itemview.findViewById(R.id.item_img)
        var itemPrice: TextView = itemview.findViewById(R.id.item_price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)

        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itm = itemList!![position]
        holder.itemName.text = itm.name
        holder.itemPrice.text = itm.price
        holder.itemImage.setImageResource(getImageId(context, itm.img))

        holder.itemImage.setOnClickListener{
            val intent = Intent(holder.itemImage.context, DetailActivity::class.java)
            intent.putExtra("name", itm.name)
            intent.putExtra("price", itm.price)
            intent.putExtra("img", getImageId(context, itm.img))
            intent.putExtra("brand", itm.brand)
            intent.putExtra("likes", itm.likes)
            intent.putExtra("path", path)
            ContextCompat.startActivity(holder.itemImage.context,intent, null)
        }
    }
    fun getImageId(context: Context, imageName: String): Int {
        return context.resources.getIdentifier("drawable/$imageName", null, context.packageName)
    }

    override fun getItemCount(): Int {
        return itemList!!.size
    }
}


