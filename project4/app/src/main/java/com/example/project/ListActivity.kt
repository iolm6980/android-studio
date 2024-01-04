package com.example.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.Adapter.ItemAdapter
import com.example.project.DataModel.Item
import com.example.project.databinding.ActivityDetailBinding

import com.example.project.databinding.ActivityListBinding
import com.google.firebase.firestore.FirebaseFirestore

class ListActivity: AppCompatActivity() {
    private lateinit var database: FirebaseFirestore
    private lateinit var binding: ActivityListBinding
    private var adapter: ItemAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = FirebaseFirestore.getInstance()

        val intent: Bundle? = intent.extras
        val path: String? = intent?.getString("path")

        if (path != null) {
            loadData(path, binding.listRecycler)
        }
        binding.domain.text = path

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
            view.layoutManager = GridLayoutManager(this, 2)
            view.itemAnimator = DefaultItemAnimator()
            view.adapter = adapter
        }
        }
    }
}