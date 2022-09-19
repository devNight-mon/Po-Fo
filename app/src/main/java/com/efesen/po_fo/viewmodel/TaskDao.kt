package com.efesen.po_fo.viewmodel

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.efesen.po_fo.model.Task

@Dao
interface TaskDao {

    @get:Query("SELECT * FROM task WHERE is_completed LIKE 1")
    val doneTasks: List<Task>

    @get:Query("SELECT * FROM task WHERE is_completed LIKE 0")
    val undoneTasks: List<Task>

    @Insert
    fun insertAll(vararg task: Task)

    @Delete
    fun delete(task: Task)

    @Query("UPDATE task SET is_completed= :isCompleted WHERE id = :id")
    fun setCompleted(isCompleted : Boolean, id : Int)

    @Query("SELECT pomodoro_amount FROM task WHERE id =:id")
    fun getPomodoroAmount(id: Int) : Int

    @Query("UPDATE task SET pomodoro_amount = :pomodoroAmount WHERE id =:id")
    fun setPomodoroAmount(pomodoroAmount: Int, id: Int)




}