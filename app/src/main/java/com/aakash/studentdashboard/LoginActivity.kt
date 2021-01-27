package com.aakash.studentdashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.aakash.studentdashboard.db.StudentDB
import com.aakash.studentdashboard.entity.User
import kotlinx.coroutines.*

class LoginActivity : AppCompatActivity(),View.OnClickListener{

    private lateinit var etUsername : EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSignIn : Button
    private lateinit var tvSignUp : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnSignIn = findViewById(R.id.btnSignIn)
        tvSignUp = findViewById(R.id.tvSignUp)

        btnSignIn.setOnClickListener {
           login()
        }

        tvSignUp.setOnClickListener(this)

    }
    private fun login(){
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()

        var user: User? = null
        CoroutineScope(Dispatchers.IO).launch {
            user = StudentDB.getInstance(this@LoginActivity)
                    .getUserDAO()
                    .checkUser(username,password)
            if (user == null){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@LoginActivity, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                startActivity(Intent(this@LoginActivity,DashboardActivity::class.java))
            }
        }
    }

    override fun onClick(v: View?){
        when(v?.id){
            R.id.tvSignUp ->{
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }

}

