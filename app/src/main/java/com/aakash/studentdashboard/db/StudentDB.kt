package com.aakash.studentdashboard.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aakash.studentdashboard.dao.StudentDAO
import com.aakash.studentdashboard.dao.UserDAO
import com.aakash.studentdashboard.entity.Student
import com.aakash.studentdashboard.entity.User
import kotlinx.coroutines.internal.synchronized

@Database(
    entities  = [(User :: class)],
    version = 1
)
abstract class StudentDB : RoomDatabase(){
    abstract fun getUserDAO() : UserDAO
//    abstract fun getStudentDAO() : StudentDAO

    companion object{
        @Volatile
        private var instance: StudentDB? = null

        fun getInstance(context: Context): StudentDB{
            if (instance==null){
                kotlin.synchronized(StudentDB::class){
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }
        private fun buildDatabase(context: Context) :StudentDB{
            return Room.databaseBuilder(
                context.applicationContext,
                StudentDB::class.java,
                "StudentDB"
            ).build()
        }

    }
}