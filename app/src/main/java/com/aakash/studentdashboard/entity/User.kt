package com.aakash.studentdashboard.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    var fname: String? = null,
    var lname : String? = null,
    var username:String? = null,
    var password: String? = null
){
    @PrimaryKey(autoGenerate = true)
    var UserId: Int = 0

}

