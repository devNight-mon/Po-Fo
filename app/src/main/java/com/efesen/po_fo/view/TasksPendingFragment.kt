package com.efesen.po_fo.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Dao
import androidx.room.Room
import com.efesen.po_fo.R
import com.efesen.po_fo.adapter.TasksPendingAdapter
import com.efesen.po_fo.viewmodel.AppDatabase
import kotlinx.android.synthetic.main.fragment_tasks_pending.view.*


class TasksPendingFragment : Fragment() {

    private var tasksPendingRecyclerView: RecyclerView? = null
    private var tasksPendingAdapter: TasksPendingAdapter? = null


    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_tasks_pending, container, false)

        val db = Room.databaseBuilder(activity?.applicationContext!!, AppDatabase::class.java, "production")
                .allowMainThreadQueries()
                .build()


        val tasksList = db.taskDao().undoneTasks

        tasksPendingRecyclerView = rootView.task_pending_recyclerview
        tasksPendingAdapter = TasksPendingAdapter(activity!!,tasksList)
        tasksPendingRecyclerView?.layoutManager = LinearLayoutManager(activity)
        tasksPendingRecyclerView?.adapter = tasksPendingAdapter

        return rootView
    }

}