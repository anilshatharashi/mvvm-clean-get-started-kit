package com.anil_shatharashi.clean.mvvm.data.repository

import com.anil_shatharashi.clean.mvvm.data.mapper.TaskDataMapper
import com.anil_shatharashi.clean.mvvm.data.repository.local.TasksDao
import com.anil_shatharashi.clean.mvvm.domain.gateway.TasksLocalGateway
import com.anil_shatharashi.clean.mvvm.domain.model.Task
import io.reactivex.Single

class TasksLocalRepository(private val tasksDao: TasksDao, private val mapper: TaskDataMapper) : TasksLocalGateway {

    override fun getTasks(): Single<List<Int>> = tasksDao.getTasks()

    override fun getTaskDetail(taskId: Int): Single<Task> = tasksDao.getTaskDetail(taskId)
            .flatMap { taskEntity -> Single.create<Task> { mapper.map(taskEntity) } }

    override fun insertTasks(task: Task): Int = tasksDao.insertTasks(mapper.inverseMap(task))

    override fun deleteTask(task: Task) {
        tasksDao.deleteTask(mapper.inverseMap(task))
    }
}