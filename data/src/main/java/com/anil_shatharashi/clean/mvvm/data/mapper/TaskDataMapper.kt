package com.anil_shatharashi.clean.mvvm.data.mapper

import com.anil_shatharashi.clean.mvvm.data.repository.local.TaskEntity
import com.anil_shatharashi.clean.mvvm.domain.mappers.TwoWaysMapper
import com.anil_shatharashi.clean.mvvm.domain.model.Task

class TaskDataMapper : TwoWaysMapper<TaskEntity, Task>{

    override fun map(model: TaskEntity): Task = Task(model.taskId, model.taskName, model.description, model.description)

    override fun inverseMap(model: Task): TaskEntity = TaskEntity(model.id, model.taskName, model.description, model.description)

}