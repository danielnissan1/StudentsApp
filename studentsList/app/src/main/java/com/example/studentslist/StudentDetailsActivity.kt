package com.example.studentslist

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.studentslist.models.Student

class StudentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val student = intent.getParcelableExtra<Student>("student")
        val studentNameTextView: TextView = findViewById(R.id.studentNameTextView)
        val studentIdTextView: TextView = findViewById(R.id.studentIdTextView)

        studentNameTextView.text = student?.name
        studentIdTextView.text = student?.id
    }
}
