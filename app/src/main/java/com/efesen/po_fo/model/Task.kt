package com.efesen.po_fo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Task(
    @field:ColumnInfo(name = "title")
    var title : String?, @field:ColumnInfo(name = "description")
    var description : String?, @field:ColumnInfo(name = "pomodoro_amount")
    var pomodoro_amount : Int, @field:ColumnInfo(name = "is_completed")
    var isCompleted : Boolean
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}