package com.example.project

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.Adapter.ItemAdapter
import com.example.project.Adapter.ReviewAdapter
import com.example.project.DataModel.Item
import com.example.project.DataModel.Review
import com.example.project.databinding.ActivityDetailBinding
import com.google.firebase.firestore.FirebaseFirestore

class DetailActivity: AppCompatActivity(){
    private lateinit var database: FirebaseFirestore
    private lateinit var binding: ActivityDetailBinding
    private var adapter: ItemAdapter? = null
    private var reviewadapter: ReviewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = FirebaseFirestore.getInstance()

        val intent: Bundle? = intent.extras
        val name: String? = intent?.getString("name")
        val price: String? = intent?.getString("price")
        val brand: String? = intent?.getString("brand")
        val path: String? = intent?.getString("path")
        val img: Int? = intent?.getInt("img")

        if (path != null) {
            loadData(path,binding.otherRecycler)
        }
        if (name != null) {
            loadReview(name, binding.reviewRecycler)
        }


        binding.desName.text = name
        binding.desPrice.text = price
        binding.desBrand.text = brand
        //binding.desLikes.text = likes.toString()
        if (img != null) {
            binding.desImg.setImageResource(img)
        }

        binding.editBtn.setOnClickListener{
            val content = binding.editText.text.toString()
            if(content.isNotEmpty()) name?.let { it1 -> addReview(it1, content) }
        }
        binding.button.setOnClickListener{
            Toast.makeText(applicationContext, "구매완료!", Toast.LENGTH_SHORT).show()
        }

    }
    private fun loadReview(name: String, view: RecyclerView){
        database.collection("review").whereEqualTo("name",name).get().addOnCompleteListener{
                task -> if(task.isSuccessful){
            var reviewList = mutableListOf<Review>()
            for(doc in task.result!!){
                val riv = doc.toObject(Review::class.java)
                reviewList.add(riv)
            }
            reviewadapter = ReviewAdapter(applicationContext, reviewList)
            view.layoutManager = GridLayoutManager(this, 1)
            view.itemAnimator = DefaultItemAnimator()
            view.adapter = reviewadapter
        }
        }
    }

    private fun loadData(path: String, view: RecyclerView){
        database.collection(path).get().addOnCompleteListener{
                task -> if(task.isSuccessful){
            var itemList = mutableListOf<Item>()
            for(doc in task.result!!){
                val item = doc.toObject(Item::class.java)
                itemList.add(item)
            }
            adapter = ItemAdapter(applicationContext, itemList, path)
            view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            view.itemAnimator = DefaultItemAnimator()
            view.adapter = adapter
        }
        }
    }

    private fun addReview(title: String, content: String) {
        val review = Review(title, content).toMap()

        database!!.collection("review")
            .add(review)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(applicationContext, "리뷰작성 성공", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(applicationContext, "리뷰작성 실패", Toast.LENGTH_SHORT).show()
            }
    }
}
