package com.efesen.po_fo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.efesen.po_fo.R
import com.efesen.po_fo.model.Task
import com.efesen.po_fo.view.PomodoroTimerActivity
import kotlinx.android.synthetic.main.list_item_task_pending.view.*

class TasksPendingAdapter(context: Context, private val mTaskPendingList: List<Task>) : RecyclerView.Adapter<TasksPendingAdapter.TasksPendingViewHolder>() {
    private val mInflater : LayoutInflater = LayoutInflater.from(context)
    private var taskName : String? = null
    private var taskId : Int = 0
    private lateinit var pomodoroActivity : Intent

    inner class TasksPendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTitle : TextView = itemView.pending_tasks_item_title
        val taskDescription : TextView = itemView.pending_tasks_item_description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksPendingViewHolder {
        val mItemView = mInflater.inflate(R.layout.list_item_task_pending,parent,false)

        val timerIcon : ImageView
        val taskNameView : TextView
        timerIcon = mItemView.pending_tasks_item_goTimer
        taskNameView = mItemView.pending_tasks_item_title
        timerIcon.setOnClickListener {
            pomodoroActivity = Intent(parent.context, PomodoroTimerActivity::class.java)
            taskName = taskNameView.text as String
            pomodoroActivity.putExtra("EXTRA_TASK_NAME", taskName)
            pomodoroActivity.putExtra("EXTRA_TASK_ID", taskId)
            parent.context.startActivity(pomodoroActivity)
        }

    return TasksPendingViewHolder(mItemView)
    }

    override fun onBindViewHolder(holder: TasksPendingViewHolder, position: Int) {
        val mCurrentPendingTask = mTaskPendingList[position]
        holder.taskTitle.text = mCurrentPendingTask.title
        holder.taskDescription.text = mCurrentPendingTask.description

        taskId = mCurrentPendingTask.id
    }

    override fun getItemCount(): Int {
       return mTaskPendingList.size
    }
}
