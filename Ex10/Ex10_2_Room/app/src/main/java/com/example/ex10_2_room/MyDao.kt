package com.example.ex10_2_room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MyDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)  // INSERT, key 충돌이 나면 새 데이터로 교체
    suspend fun insertStudent(student: Student) //student추가

    @Query("SELECT * FROM student_table")
    fun getAllStudents(): LiveData<List<Student>>        // LiveData<> 를 사용함으로 List Student이 변동 있을 때마다 리턴해줌

    @Query("SELECT * FROM student_table WHERE name = :sname")   // 메소드 인자를 SQL문에서 :을 붙여 사용
    suspend fun getStudentByName(sname: String): List<Student> //이름으로 검색하는 거

    @Delete
    suspend fun deleteStudent(student: Student); // primary key is used to find the student

}