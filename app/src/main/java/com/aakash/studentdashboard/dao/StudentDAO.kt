package com.aakash.studentdashboard.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aakash.studentdashboard.entity.Student
import com.aakash.studentdashboard.entity.User
@Dao
interface StudentDAO {

    //insert
    @Insert
    suspend fun StudentDetails(student: Student)

//    @Query("select * from Student ")
//    suspend fun getStudent(): List<Student>
}