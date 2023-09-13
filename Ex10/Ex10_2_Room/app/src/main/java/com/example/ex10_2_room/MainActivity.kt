package com.example.ex10_2_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ex10_2_room.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    //mydao라는 MyDAO클래스를 전역변수 선언
    lateinit var myDao: MyDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //database에서 getDatabase 인스턴스를 받아옴
        myDao = MyDatabase.getDatabase(this).getMyDao()

        //myDao에 있는 getAllStudents()를 가져올 allStudent변수를 만들어줌
        val allStudent = myDao.getAllStudents()
        //allStudent에다가 observe를 하면 getAllStudents() 데이터 변경이 있을 시 observe가 호출이 되면서 자동으로 변경
        allStudent.observe(this) {
            val str = StringBuilder().apply() {
                for ((id,name) in it) {
                    append(id)
                    append("-")
                    append(name)
                    append("\n")
                }//StringBuilder()를 하면서 for문을 돈다.
            }.toString()
            binding.textStudentList.text = str
        }

        //addStudent버튼 OnclickListner클릭이벤트
        binding.addStudent.setOnClickListener {
            val id = binding.editStudentId.text.toString().toInt()
            val name = binding.editStudentName.text.toString()
            if (id > 0 && name.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    myDao.insertStudent(Student(id, name))
                }
            }
            //insert가 되고 난 후 editTextView를 비워줌
            binding.editStudentId.text = null
            binding.editStudentName.text = null
        }
        //queryStudent버튼 클릭이벤트 editStudentName을 받아서 getStudentByName 이름으로 검색한다(result)
        binding.queryStudent.setOnClickListener {
            val name = binding.editStudentName.text.toString()
            CoroutineScope(Dispatchers.IO).launch {

                val result = myDao.getStudentByName(name)

                if(result.isNotEmpty()){
                    val str = StringBuilder().apply {
                        result.forEach { student ->
                            append(student.id)
                            append("-")
                            append(student.name)
                        }
                    }
                    //코루틴에서는 withContext를 걸어줘야 UI업데이트 가능
                    withContext(Dispatchers.Main){
                        binding.textQueryStudent.text = str
                    }
                }else{
                    withContext(Dispatchers.Main){
                        binding.textQueryStudent.text = ""
                    }
                }
            }
        }

    }
}
