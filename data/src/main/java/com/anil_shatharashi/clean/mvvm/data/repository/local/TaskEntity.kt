package com.anil_shatharashi.clean.mvvm.data.repository.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
data class TaskEntity (
    @PrimaryKey
    var taskId: Int,
    var taskName: String,
    var description: String,
    var notification: String
)