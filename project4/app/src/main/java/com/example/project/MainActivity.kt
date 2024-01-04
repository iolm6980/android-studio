package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.Adapter.ItemAdapter
import com.example.project.Adapter.SaleSlideAdapter
import com.example.project.DataModel.Item
import com.example.project.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

open class MainActivity : AppCompatActivity() {
    private lateinit var database: FirebaseFirestore
    private lateinit var binding: ActivityMainBinding
    private var adapter: ItemAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = FirebaseFirestore.getInstance()


        binding.clothesBtn.setOnClickListener{
            val intent = Intent(applicationContext, ListActivity::class.java)
            intent.putExtra("path", "clothes")
            startActivity(intent)
        }

        binding.shooseBtn.setOnClickListener{
            val intent = Intent(applicationContext, ListActivity::class.java)
            intent.putExtra("path", "shooes")
            startActivity(intent)
        }

        binding.pantsBtn.setOnClickListener{
            val intent = Intent(applicationContext, ListActivity::class.java)
            intent.putExtra("path", "pants")
            startActivity(intent)
        }

        binding.outerBtn.setOnClickListener{
            val intent = Intent(applicationContext, ListActivity::class.java)
            intent.putExtra("path", "outer")
            startActivity(intent)
        }


        binding.saleview.adapter = SaleSlideAdapter(this)
        loadData("clothes", binding.itemRecycler)
        loadData("shooes", binding.itemRecycler1)
        loadData("pants", binding.itemRecycler2)
        loadData("outer", binding.itemRecycler3)
    }

    private fun loadData(path: String, view:RecyclerView){
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
}

