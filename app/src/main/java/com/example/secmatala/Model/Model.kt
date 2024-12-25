package com.example.secmatala.Model

class Model private constructor(){

    val students: MutableList<Student> = ArrayList()

    companion object{
        val instance: Model = Model()
    }

    init {
        for (i in 0..20){
            val student = Student("Name: $i", "ID: $i", "sdsdds", false)
            students.add(student)
        }
    }
}