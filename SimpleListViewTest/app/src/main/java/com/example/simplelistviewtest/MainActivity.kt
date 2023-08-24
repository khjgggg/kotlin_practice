package com.example.simplelistviewtest

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.simplelistviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //데이터 원본 준비
        val items = arrayOf<String>("item1","item2","item3","item4","item5","item6","item7")

        //어댑터 준비(배열 객체 이용, simple_list_item_checked 리소스 사용)
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_checked,items)

        //어댑터를 ListView객체에 연결
        binding.listView.adapter = adapter
    }


}