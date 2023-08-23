package com.example.listviewex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listviewex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 원본 준비
        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.sample10, "Bella", "1"))
        dataList.add(MyItem(R.drawable.sample1, "Charlie", "2"))
        dataList.add(MyItem(R.drawable.sample2, "Daisy", "1.5"))
        dataList.add(MyItem(R.drawable.sample3, "Duke", "1"))
        dataList.add(MyItem(R.drawable.sample4, "Max", "2"))
        dataList.add(MyItem(R.drawable.sample5, "Happy", "4"))
        dataList.add(MyItem(R.drawable.sample6, "Luna", "3"))
        dataList.add(MyItem(R.drawable.sample7, "Bob", "2"))


        binding.listView.adapter = MyAdapter(this, dataList)

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val name = (binding.listView.adapter.getItem(position) as MyItem).aName
            Toast.makeText(this@MainActivity, "$name 선택", Toast.LENGTH_SHORT).show()
        }

    }
}