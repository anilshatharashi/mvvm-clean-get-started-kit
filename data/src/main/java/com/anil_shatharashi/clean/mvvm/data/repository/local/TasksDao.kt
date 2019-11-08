package com.anil_shatharashi.clean.mvvm.data.repository.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import io.reactivex.Single

@Dao
interface TasksDao {

    @Query("SELECT taskId FROM Task")
    fun getTasks() : Single<List<Int>>

    @Query("SELECT * FROM Task WHERE taskId=:taskId")
    fun getTaskDetail(taskId: Int) : Single<TaskEntity>

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTasks(tasks: TaskEntity) : Int

    @Delete
    fun deleteTask(task: TaskEntity)
}