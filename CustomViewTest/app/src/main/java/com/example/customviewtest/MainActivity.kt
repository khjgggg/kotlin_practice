package com.example.customviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.customviewtest.databinding.ActivityMainBinding

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
        binding.listView.adapter = MyAdapter(this, dataList)
        //항목 클릭 이벤트 처리
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val name:String = (binding.listView.adapter.getItem(position) as MyItem).aName
            Toast.makeText(this,"$name 선택!", Toast.LENGTH_SHORT).show()
        }


    }
}