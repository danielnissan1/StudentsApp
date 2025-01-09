package com.example.studentslist

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentslist.adapters.StudentAdapter
import com.example.studentslist.models.Student

class StudentListActivity : AppCompatActivity() {

    private lateinit var adapter: StudentAdapter
    private val studentList = mutableListOf<Student>()

    // Register the launcher for the Add Student screen
    private val addStudentLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val newStudent: Student? = result.data?.getParcelableExtra("newStudent")
            newStudent?.let {
                studentList.add(it)
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Student added!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        // Initialize RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewStudentList)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the adapter
        adapter = StudentAdapter(studentList) { student ->
            // Handle click on a student row to show student details
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("student", student)
            startActivity(intent)
        }

        recyclerView.adapter = adapter

        // Add sample data (optional)
        addSampleStudents()

        // Add student button
        findViewById<android.widget.Button>(R.id.addStudentButton).setOnClickListener {
            val intent = Intent(this, NewStudentActivity::class.java)
            addStudentLauncher.launch(intent)
        }
    }

    // Function to add sample students for testing
    private fun addSampleStudents() {
        studentList.add(Student("John Doe", "12345", false))
        studentList.add(Student("Jane Smith", "67890", true))
        adapter.notifyDataSetChanged()
    }
}



//package com.example.studentslist
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.studentslist.adapters.StudentAdapter
//import com.example.studentslist.models.Student
//
//class StudentListActivity : AppCompatActivity() {
//
//    private val studentList = mutableListOf<Student>()
//    private lateinit var adapter: StudentAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_student_list)
//
//        // Initialize RecyclerView
//        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewStudentList)
//        adapter = StudentAdapter(studentList) { selectedStudent ->
//            // Open Student Details when a row is clicked
//            val intent = Intent(this, StudentDetailsActivity::class.java)
//            intent.putExtra("studentId", selectedStudent.id)
//            startActivity(intent)
//        }
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        // Add a static student for testing
//        if (studentList.isEmpty()) {
//            studentList.add(Student("1", "John Doe", false))
//        }
//
//        // Notify the adapter that the dataset has changed
//        adapter.notifyDataSetChanged()
//
//        // Button to add a new student
//        val addStudentButton: Button = findViewById(R.id.addStudentButton)
//        addStudentButton.setOnClickListener {
//            val intent = Intent(this, NewStudentActivity::class.java)
//            startActivity(intent)
//        }
//    }
//
//    override fun onResume() {
//        super.onResume()
//        // Update the adapter data (if new students were added)
//        adapter.notifyDataSetChanged()
//    }
//}
