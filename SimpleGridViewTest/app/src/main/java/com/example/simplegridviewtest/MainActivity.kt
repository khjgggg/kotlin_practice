package com.example.simplegridviewtest

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.simplegridviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//       //데이터 원본 준비
//        val items = arrayOf<String?>("item1","item2","item3","item4","item5","item6","item7","item8","item9","item10")
//
//       //어댑터 준비
//        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1,items)

        //어댑터를 GridView 객체에 연결
        binding.gridview.adapter = ImageAdapter()

        //항목 클릭 이벤트 처리
        binding.gridview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(
                this@MainActivity, "" + "${position + 1}번째 선택", Toast.LENGTH_SHORT
            ).show()
        }


    }
}

