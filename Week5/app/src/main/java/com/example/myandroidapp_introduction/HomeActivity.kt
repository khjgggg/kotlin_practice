package com.example.myandroidapp_introduction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.myandroidapp_introduction.R.*


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_home)

        val id = intent.getStringExtra("Id")
        val textViewId = findViewById<TextView>(R.id.textViewId)
        textViewId.text = "아이디 : $id"

        val btnEnd = findViewById<TextView>(R.id.btnEnd)
        btnEnd.setOnClickListener{
           finish()
        }

        val randomImage = findViewById<ImageView>(R.id.imageViewHome)

        val random = when((1..6).random()){
            1-> R.drawable.img_1
            2-> R.drawable.img_2
            3-> R.drawable.img_3
            4-> R.drawable.img_4
            5-> R.drawable.img_5
            else-> R.drawable.img_1
        }
        randomImage.setImageDrawable(ResourcesCompat.getDrawable(resources,random,null))

        }



    }

