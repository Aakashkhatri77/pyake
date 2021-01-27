package com.aakash.studentdashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnCountries: EditText
    private lateinit var btnRoomDatabase: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCountries = findViewById(R.id.btnCountries)
        btnRoomDatabase = findViewById(R.id.btnroomDatabse)

        btnCountries.setOnClickListener(this)
        btnRoomDatabase.setOnClickListener(this)

    }
    override fun onClick(v: View?){
        when(v?.id){
            R.id.btnCountries ->{
                val intent = Intent(this, CountriesActivity::class.java)
                startActivity(intent)
            }

            R.id.btnroomDatabse ->{
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}