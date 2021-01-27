package com.aakash.studentdashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.aakash.studentdashboard.db.StudentDB
import com.aakash.studentdashboard.entity.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class SignUpActivity : AppCompatActivity(){
    private  lateinit var etFirstName: EditText
    private lateinit var etLastName : EditText
    private lateinit var etUsername : EditText
    private lateinit var etPassword : EditText
    private lateinit var etConfirmPassword : EditText
    private lateinit var btnAddUser : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        etFirstName = findViewById(R.id.etFirstname)
        etLastName = findViewById(R.id.etLastname)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnAddUser = findViewById(R.id.btnAddUser)

        btnAddUser.setOnClickListener{
            val fname = etFirstName.text.toString()
            val lname = etLastName.text.toString()
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (password!= confirmPassword){
                etPassword.error = "Password does not match"
                etPassword.requestFocus()
                return@setOnClickListener
            }else{
                val user = User(fname, lname, username, password)
                CoroutineScope(Dispatchers.IO).launch{
                    StudentDB
                        .getInstance(this@SignUpActivity)
                        .getUserDAO()
                        .RegisterUser(user)

                    //Switch to main thread
                    withContext(Main){
                        Toast.makeText(this@SignUpActivity, "User saved", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}