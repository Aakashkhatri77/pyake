package com.aakash.studentdashboard

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aakash.studentdashboard.adapter.StudentAdapter
import com.aakash.studentdashboard.entity.Student

class ViewStudentActivity : AppCompatActivity() {
    private var lstStudents = ArrayList<Student>()
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<StudentAdapter.StudentViewHolder>? = null
    private lateinit var rvStudentDetails: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student)

        rvStudentDetails = findViewById(R.id.rvStudentDetails)
        lstStudents.add(Student("Aakash", "21", "Male", "Bhaktapur"))
        val adapter = StudentAdapter( this, lstStudents)
        rvStudentDetails.layoutManager= LinearLayoutManager(this)
        rvStudentDetails.adapter= adapter
    }

}