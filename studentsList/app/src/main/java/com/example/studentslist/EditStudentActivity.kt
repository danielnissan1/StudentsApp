package com.example.studentslist

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.studentslist.models.Student
import com.example.studentslist.repositories.StudentRepository

class EditStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val student = intent.getParcelableExtra<Student>("student")

        val studentNameEditText: EditText = findViewById(R.id.studentNameEditText)
        val studentIdEditText: EditText = findViewById(R.id.studentIdEditText)
        val checkStatus: CheckBox = findViewById(R.id.checkStatusCheckBox)
        val updateButton: Button = findViewById(R.id.updateButton)
        val deleteButton: Button = findViewById(R.id.deleteButton)

        student?.let {
            studentNameEditText.setText(it.name)
            studentIdEditText.setText(it.id)
            checkStatus.isChecked = it.checkStatus
        }

        // Update student details
        updateButton.setOnClickListener {
            val updatedName = studentNameEditText.text.toString()
            val updatedId = studentIdEditText.text.toString()
            val updatedCheckStatus = checkStatus.isChecked

            if (updatedName.isNotBlank() && updatedId.isNotBlank()) {
                val updatedStudent = Student(updatedId, updatedName, updatedCheckStatus)
                StudentRepository.updateStudent(updatedStudent)

                Toast.makeText(this, "Student updated", Toast.LENGTH_SHORT).show()
                finish()  // Close the activity
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Delete student
        deleteButton.setOnClickListener {
            student?.let {
                StudentRepository.deleteStudent(it)
                Toast.makeText(this, "Student deleted", Toast.LENGTH_SHORT).show()
                finish()  // Close the activity
            }
        }
    }
}
