package com.efesen.po_fo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.efesen.po_fo.R
import com.efesen.po_fo.adapter.TabsAssessorAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarSupport()
        setAdapterSupport()

    }

    private fun setActionBarSupport() {
        setSupportActionBar(main_page_toolbar as Toolbar)
        supportActionBar?.let {
            it.title= "Tasks"
            it.setDisplayHomeAsUpEnabled(false)
            it.setDisplayShowCustomEnabled(false)
        }
    }
    private fun setAdapterSupport(){
        main_tabs_pager?.adapter = TabsAssessorAdapter(supportFragmentManager)
        main_tabs?.setupWithViewPager(main_tabs_pager)
    }

  fun displayNewTaskActivity(view: View){
      val newTaskActivity = Intent(this@MainActivity, NewTaskActivity::class.java)
      startActivity(newTaskActivity)


  }
}