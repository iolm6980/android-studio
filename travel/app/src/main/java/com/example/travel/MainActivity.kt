package com.example.travel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var adapter: DesAdapter? = null
    private var desList: MutableList<Destination>? = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        adapter = DesAdapter(this, desList)
        recyclerView?.layoutManager = GridLayoutManager(this, 1)
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.adapter = adapter
        prepareAlbums()

    }
    public  fun qwe(view: View){
        Toast.makeText(getApplicationContext(), "짧게 출력 Hello World!", Toast.LENGTH_SHORT).show()
    }

    private fun prepareAlbums() {
        val covers = intArrayOf(
            R.drawable.album1,
            R.drawable.album2,
            R.drawable.album3,
            R.drawable.album4,
            R.drawable.album5,
            R.drawable.album6,
            R.drawable.album7,
            R.drawable.album8,
            R.drawable.album9,
            R.drawable.album10,
            R.drawable.album11)
        var a = Destination("Love poem",  covers[0])
        desList!!.add(a)
        a = Destination("CHANNEL 8", covers[1])
        desList!!.add(a)
        a = Destination("Purpose-The 2nd Album", covers[2])
        desList!!.add(a)
        a = Destination("항해", covers[3])
        desList!!.add(a)
        a = Destination("Rewind",  covers[4])
        desList!!.add(a)
        a = Destination("Feel Special", covers[5])
        desList!!.add(a)
        a = Destination("Speak Your Mind",  covers[6])
        desList!!.add(a)
        a = Destination("I met you when I was 18", covers[7])
        desList!!.add(a)
        a = Destination("Hello",  covers[8])
        desList!!.add(a)
        a = Destination("Greatest Hits",  covers[9])
        desList!!.add(a)
        adapter!!.notifyDataSetChanged()
    }

}