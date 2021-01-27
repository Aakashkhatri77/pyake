package com.aakash.studentdashboard.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
        var etName: String? = null,
        var etAge : String? = null,
        var rgGender: String? = null,
        var etAddress : String? = null
){
    @PrimaryKey(autoGenerate = true)
    var StudentId : Int = 0
}
