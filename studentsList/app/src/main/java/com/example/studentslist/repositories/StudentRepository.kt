package com.example.studentslist.repositories

import com.example.studentslist.models.Student

object StudentRepository {
    val students = mutableListOf<Student>()

    // Function to add a new student
    fun addStudent(student: Student) {
        students.add(student)
    }

    // Function to get all students
    fun getAllStudents(): List<Student> {
        return students
    }

    // Function to get a student by ID
    fun getStudentById(id: String): Student? {
        return students.find { it.id == id }
    }

    // Function to update a student
    fun updateStudent(updatedStudent: Student) {
        val student = students.find { it.id == updatedStudent.id }
        student?.apply {
            name = updatedStudent.name
            checkStatus = updatedStudent.checkStatus
        }
    }

    // Function to delete a student
    fun deleteStudent(student: Student) {
        students.remove(student)
    }
}
