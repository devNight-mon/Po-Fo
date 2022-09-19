package com.efesen.po_fo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.room.Room
import com.efesen.po_fo.R
import com.efesen.po_fo.model.Task
import com.efesen.po_fo.viewmodel.AppDatabase
import kotlinx.android.synthetic.main.activity_new_task.*

class NewTaskActivity : AppCompatActivity(), NewTask.View {
    private lateinit var db : AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)
        this.setSupportToActionBar()


        task_title.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                when {
                    p0.toString().trim().isEmpty() -> save_task_button.visibility = View.GONE
                    else -> save_task_button.visibility = View.VISIBLE
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
        db= Room.databaseBuilder(this,AppDatabase::class.java,"production")
            .allowMainThreadQueries()
            .build()
    }

    override fun setSupportToActionBar() {
        setSupportActionBar(main_page_toolbar as Toolbar)
        supportActionBar?.let {
            it.title = "New Task"
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowCustomEnabled(true)
        }
    }

    fun saveTask(view: View) {
        val title = task_title.text.toString()
        val description = task_description.text.toString()
        val pomodoroAmount = 4
        val isCompeted = false

        db.taskDao().insertAll(Task(title,description,pomodoroAmount,isCompeted))

        val mainActivityIntent = Intent(this@NewTaskActivity,MainActivity::class.java)
        mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(mainActivityIntent)
        this.finish()
    }
}