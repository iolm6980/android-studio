package com.example.project.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.DataModel.Review
import com.example.project.R

class ReviewAdapter(val context: Context, val reviewList: MutableList<Review>): RecyclerView.Adapter<ReviewAdapter.MyViewHolder>(){
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val review: TextView = view.findViewById(R.id.review_text)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.review_card, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewAdapter.MyViewHolder, position: Int) {
        val re = reviewList!![position]
        holder.review.text = re.content
    }

    override fun getItemCount(): Int {
        return reviewList!!.size
    }

}


