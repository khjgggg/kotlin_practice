package com.example.a5_veiwbinding

import com.example.a5_veiwbinding.R
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import com.example.a5_veiwbinding.databinding.ActivityMainBinding
import com.example.a5_veiwbinding.databinding.RidoLoveMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: RidoLoveMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        binding = RidoLoveMainBinding.inflate(layoutInflater)
//
//        val view = binding.root
//
//        setContentView(view)
//
//        binding.myTestView.setOnClickListener {
//            it.setBackgroundColor(Color.BLACK)
//        }
//
//        val items = arrayOf<String?>("item0","item1","item2","item3","item4","item5","item6","item7", "item8", "item0","item1","item2","item3","item4","item5","item6","item7", "item8")
//
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
//
//
////        binding.listView.adapter = adapter
//
//        binding.gridView.adapter = ImageAdapter()
//
//
//        binding.gridView.setOnItemClickListener { parent, view, position, id ->
//            Toast.makeText( this@MainActivity, "${position + 1}번째 선택",  Toast.LENGTH_SHORT).show()
//        }
//    }

}
