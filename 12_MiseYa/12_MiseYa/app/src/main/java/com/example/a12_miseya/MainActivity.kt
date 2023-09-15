package com.example.a12_miseya

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.a12_miseya.data.DustItem
import com.example.a12_miseya.databinding.ActivityMainBinding
import com.example.a12_miseya.retrofit.NetWorkClient
import com.skydoves.powerspinner.IconSpinnerAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var items = mutableListOf<DustItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.spinnerViewSido.setOnSpinnerItemSelectedListener<String> { _, _, _, text ->
            communicateNetWork(setUpDustParameter(text))
        }
        binding.spinnerViewGoo.setOnSpinnerItemSelectedListener<String> { _, _, _, text ->

            Log.d("miseya", "selectedItem: spinnerViewGoo selected >  $text")
            var selectedItem = items.filter { f -> f.stationName == text }
            Log.d("miseya", "selectedItem: sidoName > " + selectedItem[0].sidoName)
            Log.d("miseya", "selectedItem: pm10Value > " + selectedItem[0].pm10Value)
            //실시간 데이터이기 때문에 0번째만 씀
            binding.tvCityname.text = selectedItem[0].sidoName + "  " + selectedItem[0].stationName
            binding.tvDate.text = selectedItem[0].dataTime
            binding.tvP10value.text = selectedItem[0].pm10Value + " ㎍/㎥"

            // 미세먼지 등급에 따라 화면을 설정
            when (getGrade(selectedItem[0].pm10Value)) {
                1 -> {
                    binding.mainBg.setBackgroundColor(Color.parseColor("#9ED2EC"))
                    binding.ivFace.setImageResource(R.drawable.mise1)
                    binding.tvP10grade.text = "좋음"
                }

                2 -> {
                    binding.mainBg.setBackgroundColor(Color.parseColor("#D6A478"))
                    binding.ivFace.setImageResource(R.drawable.mise2)
                    binding.tvP10grade.text = "보통"
                }

                3 -> {
                    binding.mainBg.setBackgroundColor(Color.parseColor("#DF7766"))
                    binding.ivFace.setImageResource(R.drawable.mise3)
                    binding.tvP10grade.text = "나쁨"
                }

                4 -> {
                    binding.mainBg.setBackgroundColor(Color.parseColor("#BB3320"))
                    binding.ivFace.setImageResource(R.drawable.mise4)
                    binding.tvP10grade.text = "매우나쁨"
                }
            }
        }
    }

    // 네트워크 통신을 수행하는 함수 반드시 비동기 사용
    private fun communicateNetWork(param: HashMap<String, String>) = lifecycleScope.launch() {

        val responseData = NetWorkClient.dustNetWork.getDust(param)
        Log.d("Parsing Dust ::", responseData.toString())

        val adapter = IconSpinnerAdapter(binding.spinnerViewGoo)
        items = responseData.response.dustBody.dustItem!!

        val goo = ArrayList<String>()
        items.forEach {
            goo.add(it.stationName)
        }
        //UI스레드(백그라운드 스레드와는 분리해서 사용)
        runOnUiThread {
            binding.spinnerViewGoo.setItems(goo)
        }

    }

    // 네트워크 요청 파라미터 설정을 위한 함수
    private fun setUpDustParameter(sido: String): HashMap<String, String> {
        //환경공단에서 발급받은 authkey
        val authKey =
            "COI9MjznAG0Nu9MMFAxmIbrSx3SG2iZ6yvaZeaOv9+fwzT/qSqpkvKlLRXbLZMnZEkGf8ue7NQkl1lCxj4vMWg=="
        //환경공단의 요청변수의 항목명과 정확하게 일치하여야 함
        return hashMapOf(
            "serviceKey" to authKey,
            "returnType" to "json",
            "numOfRows" to "100",
            "pageNo" to "1",
            "sidoName" to sido,
            "ver" to "1.0"
        )
    }

    // 미세먼지 등급을 계산하는 함수
    fun getGrade(value: String): Int {
        val mValue = value.toInt()
        var grade = 1
        grade = if (mValue >= 0 && mValue <= 30) {
            1
        } else if (mValue >= 31 && mValue <= 80) {
            2
        } else if (mValue >= 81 && mValue <= 100) {
            3
        } else 4
        return grade
    }
}