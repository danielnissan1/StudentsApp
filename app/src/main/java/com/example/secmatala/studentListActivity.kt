package com.example.secmatala

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.secmatala.Model.Model
import com.example.secmatala.Model.Student


class studentListActivity : AppCompatActivity() {
    var studentList: ListView? = null
    var students: MutableList<Student>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        students = Model.instance.students

        studentList = findViewById(R.id.ListViewStudentList)
        studentList?.adapter = studentListAdapter(students)

        studentList?.setOnItemClickListener{ parent, view, position, id ->
            Log.i("TAG", "row was clicked at $position")
        }
    }

    class studentListAdapter(val students: MutableList<Student>?) : BaseAdapter() {
        override fun getCount(): Int = students?.size ?: 0

        override fun getItem(p0: Int): Any {
            TODO("Not yet implemented")
        }

        override fun getItemId(p0: Int): Long = 0

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val student = students?.get(position)
            var view: View? = null

            if (convertView == null) {
                view = LayoutInflater.from(parent?.context)
                    .inflate(R.layout.student_list_row, parent, false)

                val studentCheckBox: CheckBox? = view?.findViewById(R.id.studentListRowCheck)
                studentCheckBox?.apply {
                    setOnClickListener{

                        (studentCheckBox.tag as? Int)?. let { tag ->
                            var student = students?.get(tag)
                            student?.isChecked = studentCheckBox?.isChecked ?: false
                        }

                    }
                }
            }

            view = view ?: convertView

            val nameTextView: TextView? = view?.findViewById(R.id.studentListRowName)
            val idTextView: TextView? = view?.findViewById(R.id.studentListRowID)
            val studentCheckBox: CheckBox? = view?.findViewById(R.id.studentListRowCheck)
            nameTextView?.text = student?.name
            idTextView?.text = student?.id
            studentCheckBox?.apply {
                isChecked = student?.isChecked ?: false
                tag = position
            }



            return view!!

        }
    }
}

