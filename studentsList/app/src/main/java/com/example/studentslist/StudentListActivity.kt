package com.example.studentslist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentslist.adapters.StudentAdapter
import com.example.studentslist.models.Student

class StudentListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var studentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        recyclerView = findViewById(R.id.recyclerViewStudentList)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Assuming you have a list of students from somewhere (e.g., in-memory list)
        val students = mutableListOf<Student>()
        // Add some test students to the list
        students.add(Student("1", "John Doe", false))
        students.add(Student("2", "Jane Doe", true))

        studentAdapter = StudentAdapter(students) { student ->
            // On student item click, open StudentDetailsActivity
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("student", student)
            startActivity(intent)
        }

        recyclerView.adapter = studentAdapter
    }
}
