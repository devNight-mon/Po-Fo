package com.efesen.po_fo.viewmodel

import androidx.room.Database
import androidx.room.RoomDatabase
import com.efesen.po_fo.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}