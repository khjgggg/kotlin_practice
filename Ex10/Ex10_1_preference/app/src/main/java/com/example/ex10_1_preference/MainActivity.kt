package com.example.ex10_1_preference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ex10_1_preference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //saveData 버튼클릭이벤트,토스트 메시지 "Data Saved." 그리고 loadData
        binding.btnSave.setOnClickListener {
            saveData()
            Toast.makeText(this,"Data Saved.",Toast.LENGTH_SHORT).show()
        }
        loadData()
    }
    /*저장하기
    saveData함수 선언 pref란 파일이름으로 preference를 하나 만든다. getSharedPreferences는 여러개의 Shared Preference파일들을 사용하는 경우에 쓰임*/
    private fun saveData(){
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit()//edit 수정모드
        //edit를 할 때 putString 값으로 name이라는 키에다가 editText에 써있는 것을 집어넣을 것 그리고 apply로 저장완료
        edit.putString("name",binding.etHello.text.toString())//1번째 인자는 키, 2번째 인자는 실제 담아둘 값
        edit.apply()
    }
    /*불러오기
    loadData함수 선언 pref란 파일이름으로 preference를 하나 만든다.*/
    private fun loadData(){
        val pref = getSharedPreferences("pref",0)
        //getString을 하는데 내가 저장한 키값을 준다. 그리고 불러와서 editText에다가 집어넣는다.
        // 불러올 때는 defValue를 지정해주어야 함 왜냐하면 내가 set을 하지 않은 상태로 get을 먼저 할 수도 있으므로
        binding.etHello.setText(pref.getString("name",""))//1번째 인자는 키, 2번째 인자는 데이터가 존재하지 않을 경우의 값

    }




}
