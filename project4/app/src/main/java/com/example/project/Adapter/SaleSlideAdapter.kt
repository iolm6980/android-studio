package com.example.project.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.project.R
import com.example.project.fragment.SaleFragment

class SaleSlideAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    private val saleItem = listOf<Int>(
        R.drawable.sale01, R.drawable.sale02,
        R.drawable.sale03, R.drawable.sale04, R.drawable.sale05, R.drawable.sale06,
        R.drawable.sale07, R.drawable.sale08)
    override fun getItemCount(): Int {
        return saleItem.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> SaleFragment.newInstance(saleItem[0])
            1 -> SaleFragment.newInstance(saleItem[1])
            2 -> SaleFragment.newInstance(saleItem[2])
            3 -> SaleFragment.newInstance(saleItem[3])
            4 -> SaleFragment.newInstance(saleItem[4])
            5 -> SaleFragment.newInstance(saleItem[5])
            6 -> SaleFragment.newInstance(saleItem[6])
            7 -> SaleFragment.newInstance(saleItem[7])
            8 -> SaleFragment.newInstance(saleItem[8])

            else -> SaleFragment()
        }
    }
}