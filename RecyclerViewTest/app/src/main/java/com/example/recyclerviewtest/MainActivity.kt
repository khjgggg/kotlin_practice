package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    //데이터 원본 준비
        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.img_8700, "전지현", "45"))
        dataList.add(MyItem(R.drawable.img_8703, "송혜교", "35"))
        dataList.add(MyItem(R.drawable.img_8704, "김태희", "29"))
        dataList.add(MyItem(R.drawable.img_8705, "한가인", "26"))
        dataList.add(MyItem(R.drawable.img_8706, "수지", "22"))
        dataList.add(MyItem(R.drawable.img_8707, "제니", "19"))
        dataList.add(MyItem(R.drawable.img_8709, "지수", "31"))
        dataList.add(MyItem(R.drawable.img_8711, "김현정", "32"))
        //어댑터 생성 및 연결
//        binding.recyclerView.adapter = MyAdapter(dataList)
        val adapter = MyAdapter(dataList)
        binding.recyclerView.adapter = adapter
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val size = dataList.size
                val name = dataList[size-position-1].aName
                Toast.makeText(this@MainActivity, "$name 선택!!!!!!", Toast.LENGTH_SHORT).show()
            }
        }


    }
}