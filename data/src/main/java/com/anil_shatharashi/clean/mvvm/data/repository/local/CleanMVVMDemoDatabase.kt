package com.anil_shatharashi.clean.mvvm.data.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
abstract class CleanMVVMDemoDatabase : RoomDatabase() {

    abstract fun getTasksDao(): TasksDao
}
