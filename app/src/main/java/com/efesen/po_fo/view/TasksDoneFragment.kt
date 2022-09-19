package com.efesen.po_fo.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.efesen.po_fo.R
import com.efesen.po_fo.adapter.TasksDoneAdapter
import com.efesen.po_fo.viewmodel.AppDatabase
import kotlinx.android.synthetic.main.fragment_tasks_done.view.*


class TasksDoneFragment : Fragment() {
    private var tasksDoneRecyclerView: RecyclerView? = null
    private var tasksDoneAdapter: TasksDoneAdapter? = null

    private val swipeCallBack = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val layoutPosition = viewHolder.layoutPosition
            val selectedTask = tasksDoneAdapter?.doneTaskList?.get(layoutPosition)

            val db = Room.databaseBuilder(
                activity?.applicationContext!!,
                AppDatabase::class.java,
                "production"
            )
                .allowMainThreadQueries().build()
            if (selectedTask != null) {
                db.taskDao().delete(selectedTask)

            }
        }

    }


    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_tasks_done, container, false)

        val db = Room.databaseBuilder(
            activity?.applicationContext!!,
            AppDatabase::class.java,
            "production"
        )
            .allowMainThreadQueries().build()


        val tasksList = db.taskDao().doneTasks

        tasksDoneRecyclerView = rootView.task_done_recyclerview
        tasksDoneAdapter = TasksDoneAdapter(activity!!, tasksList)
        tasksDoneRecyclerView?.layoutManager = LinearLayoutManager(activity)
        tasksDoneRecyclerView?.adapter = tasksDoneAdapter
        ItemTouchHelper(swipeCallBack).attachToRecyclerView(tasksDoneRecyclerView)

        return rootView
    }

}
