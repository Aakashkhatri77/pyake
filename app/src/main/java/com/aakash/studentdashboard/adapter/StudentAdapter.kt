package com.aakash.studentdashboard.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.aakash.studentdashboard.R
import com.aakash.studentdashboard.UpdateStudentActivity
import com.aakash.studentdashboard.entity.Student

class StudentAdapter(
        private val context: Context,
        private val lstStudents: List<Student>
): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    class StudentViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvAge : TextView = view.findViewById(R.id.tvAge)
        val ibUpdate: ImageButton = view.findViewById(R.id.ibUpdate)
        val ibDelete: ImageButton = view.findViewById(R.id.ibDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.custom_student_layout,parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = lstStudents[position]
        holder.tvName.text = student.etName
        holder.tvAge.text = student.etAge.toString()

//        holder.ibUpdate.setOnClickListener {
//            val intent = Intent(context,UpdateStudentActivity::class.java)
//            intent.putExtra("student", student)
//            context.startActivity(intent)
//        }
//
//        holder.ibDelete.setOnClickListener {
//            val builder = AlertDialog.Builder(context)
//            builder.setTitle("DeleteStudent")
//            builder.setMessage("Are you sure you want to delete ${student.etName} ??")
//            builder.setIcon(android.R.drawable.ic_dialog_alert)
//            builder.setPositiveButton("Yes"){_, _  -> deleteStudent(student)
//            }
//            builder.setNegativeButton("No"){_, _ ->
//                Toast.makeText(context, "Action Cancelled", Toast.LENGTH_SHORT).show()
//            }
//            val alertDialog: AlertDialog = builder.create()
//            alertDialog.setCancelable(false)
//            alertDialog.show()
//        }
    }

    override fun getItemCount(): Int {
        return lstStudents.size
    }
}