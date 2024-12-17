package com.example.secmatala

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddStudentActivity : AppCompatActivity() {

    var nameTextField: EditText? = null
    var idTextField: EditText? =  null
    var nameTextView: TextView? = null
    var idTextView: TextView? = null
    var messageTextView: TextView? = null
    var saveButton: Button? = null
    var cancleButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setUpUI()
    }

    private fun setUpUI() {
        nameTextField = findViewById(R.id.editTxtName)
        idTextField = findViewById(R.id.editTxtId)

        nameTextView = findViewById(R.id.txtName)
        idTextView = findViewById(R.id.txtId)
        messageTextView = findViewById(R.id.messageText)

        saveButton = findViewById(R.id.btnAddStudentSave)
        cancleButton = findViewById(R.id.btnAddStudentCancle)

        cancleButton?.setOnClickListener{
            finish()
        }

        saveButton?.setOnClickListener{
         val name = nameTextField?.text.toString()
         messageTextView?.text = name
        }
    }
}