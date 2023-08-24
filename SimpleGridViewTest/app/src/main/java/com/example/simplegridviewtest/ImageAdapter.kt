package com.example.simplegridviewtest

import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView

class ImageAdapter : BaseAdapter() {
    override fun getCount(): Int {
        return mThmubIds.size
    }

    override fun getItem(position: Int): Any {
        return mThmubIds[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView
        if (convertView == null){
            imageView = ImageView(parent!!.context)
            imageView.layoutParams = AbsListView.LayoutParams(200,200)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(1,1,1,1)

        } else {
            imageView = convertView as ImageView
        }
        imageView.setImageResource(mThmubIds.get(position))
        return imageView
    }
    private val mThmubIds = arrayOf<Int>(
        R.drawable.sample1, R.drawable.sample2,
        R.drawable.sample3, R.drawable.sample4,
        R.drawable.sample5, R.drawable.sample6,
        R.drawable.sample7, R.drawable.sample8,
        R.drawable.sample9, R.drawable.sample10,
        R.drawable.sample1, R.drawable.sample2,
        R.drawable.sample3, R.drawable.sample4,
        R.drawable.sample5, R.drawable.sample6,
        R.drawable.sample7, R.drawable.sample8,
        R.drawable.sample9, R.drawable.sample10,
        R.drawable.sample1, R.drawable.sample2,
        R.drawable.sample3, R.drawable.sample4,
        R.drawable.sample5, R.drawable.sample6,
        R.drawable.sample7, R.drawable.sample8,
        R.drawable.sample9, R.drawable.sample10
    )
}