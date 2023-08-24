package com.example.customviewtest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter (val mContext:Context, val mItems: MutableList<MyItem>) : BaseAdapter(){
    override fun getCount(): Int {
        return mItems.size
    }

    override fun getItem(position: Int): Any {
        return mItems[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    //position위치의 항목에 해당하는 항목뷰를 반환하는 것이 목적
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.item,parent,false)
        }
        val item : MyItem = mItems[position]

        //convertView변수로 참조되는 항목 뷰 객체내에 포함된 객체를 id를 통해 얻어옴
        val iconImageView = convertView?.findViewById<View>(R.id.iconItem) as ImageView
        val tv_name = convertView.findViewById<TextView>(R.id.textItem1)as TextView
        val tv_age = convertView.findViewById<TextView>(R.id.textItem2)as TextView

        //어댑터가 관리하는 항목 데이터 중에서 position 위치의 항목의 객체를 해당 항목에 설정
        iconImageView.setImageResource(item.aIcon)
        tv_name.text = item.aName
        tv_age.text = item.aAge

        return convertView

    }

}