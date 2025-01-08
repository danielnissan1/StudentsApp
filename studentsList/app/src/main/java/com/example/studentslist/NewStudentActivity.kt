package com.example.studentslist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.studentslist.StudentListActivity
import com.example.studentslist.models.Student
import com.example.studentslist.repositories.StudentRepository
import java.util.UUID

class NewStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        val studentNameEditText: EditText = findViewById(R.id.studentNameEditText)
        val addStudentButton: Button = findViewById(R.id.addStudentButton)

        addStudentButton.setOnClickListener {
            val studentName = studentNameEditText.text.toString()
            if (studentName.isNotEmpty()) {
                val newStudent = Student(id = UUID.randomUUID().toString(), name = studentName)
                StudentRepository.addStudent(newStudent)

                val intent = Intent(this, StudentListActivity::class.java)
                startActivity(intent)
                finish()  // Close the NewStudentActivity
            }
        }
    }
}
