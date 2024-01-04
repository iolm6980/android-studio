package com.example.travel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DesAdapter(val context: Context, val desList: MutableList<Destination>?) : RecyclerView.Adapter<DesAdapter.MyViewHolder>() {
    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val desName: TextView = itemview.findViewById(R.id.des_name)
        val desImage: ImageView = itemview.findViewById(R.id.des_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val des = desList!![position]
        holder.desName.text = des.desName
        holder.desImage.setImageResource(des.desImage)
    }

    override fun getItemCount(): Int {
        return desList!!.size
    }

}
