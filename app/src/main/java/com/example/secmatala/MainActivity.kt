package com.example.secmatala

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val addStudentButton: Button = findViewById(R.id.btnMainAddStudent)

//        class buttonOnClickListener: View.OnClickListener {
//            override fun onClick(v: View?) {
//                TODO("Not yet implemented")
//            }
//
//        }
//
//        val listener = buttonOnClickListener()
//        addStudentButton.setOnClickListener(listener)

        addStudentButton.setOnClickListener(::onAddStudentButtonClicked)

        }
    fun onAddStudentButtonClicked(view:View) {
        val intent = Intent(this, AddStudentActivity::class.java)
        startActivity(intent)
    }
}