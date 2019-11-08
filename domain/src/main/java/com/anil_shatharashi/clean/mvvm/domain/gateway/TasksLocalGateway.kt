package com.anil_shatharashi.clean.mvvm.domain.gateway

import com.anil_shatharashi.clean.mvvm.domain.model.Task
import io.reactivex.Single

interface TasksLocalGateway {

    fun getTasks(): Single<List<Int>>

    fun getTaskDetail(taskId: Int): Single<Task>

    fun insertTasks(task: Task) : Int

    fun deleteTask(task: Task)
}