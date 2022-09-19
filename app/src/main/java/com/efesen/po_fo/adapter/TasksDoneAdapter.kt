package com.efesen.po_fo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.efesen.po_fo.R
import com.efesen.po_fo.model.Task
import kotlinx.android.synthetic.main.list_item_task_done.view.*

class TasksDoneAdapter(context: Context,  val doneTaskList: List<Task>) :
    RecyclerView.Adapter<TasksDoneAdapter.TasksDoneViewHolder>() {
    private val mInflater : LayoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksDoneViewHolder {
        val itemView = mInflater.inflate(R.layout.list_item_task_done,parent,false)
        return TasksDoneViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: TasksDoneViewHolder, position: Int) {
        val currentDoneTask = doneTaskList[position]
        holder.apply {
            taskTitle.text = currentDoneTask.title
            taskDescription.text = currentDoneTask.description
        }
    }

    override fun getItemCount(): Int {
       return doneTaskList.size
    }


    inner class TasksDoneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTitle: TextView = itemView.done_tasks_item_title
        val taskDescription: TextView = itemView.done_tasks_item_description


    }
}