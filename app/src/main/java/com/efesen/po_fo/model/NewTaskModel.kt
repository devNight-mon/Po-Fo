package com.efesen.po_fo.model

data class NewTaskModel(
    var title : String,
    var description : String,
    var pomodoroAmount : Int,
    var isCompleted : Boolean
)
