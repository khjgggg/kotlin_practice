package com.example.recyclerviewtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtest.databinding.ItemRecyclerviewBinding

class MyAdapter(val dataList: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>(){

    interface ItemClick{
        fun onClick(view: View, position: Int )
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: MyAdapter.Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        val size = dataList.size
        holder.iconImageView.setImageResource(dataList[size - position - 1].aIcon)
        holder.name.text = dataList[size - position -1].aName
        holder.age.text = dataList[size - position - 1].aAge

    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.iconItem
        val name = binding.textItem1
        val age = binding.textItem2
    }


}