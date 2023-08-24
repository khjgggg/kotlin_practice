package com.example.notificationtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.notificationtest.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}