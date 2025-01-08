package com.example.studentslist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentslist.R
import com.example.studentslist.models.Student

class StudentAdapter(private val students: MutableList<Student>, private val onStudentClick: (Student) -> Unit) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.bind(student)

        // Setting up the click listener for each item in the list
        holder.itemView.setOnClickListener {
            onStudentClick(student)
        }

        // Setting up the checkbox click to change check status
        holder.checkStatus.isChecked = student.checkStatus
        holder.checkStatus.setOnCheckedChangeListener { _, isChecked ->
            student.checkStatus = isChecked
        }
    }

    override fun getItemCount(): Int {
        return students.size
    }

    // ViewHolder for the individual student item
    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val studentName: TextView = itemView.findViewById(R.id.studentName)
        private val studentId: TextView = itemView.findViewById(R.id.studentId)
        val checkStatus: CheckBox = itemView.findViewById(R.id.checkBoxStatus)

        fun bind(student: Student) {
            studentName.text = student.name
            studentId.text = student.id
        }
    }
}
