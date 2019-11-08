package com.anil_shatharashi.clean.mvvm.domain.usecases

import com.anil_shatharashi.clean.mvvm.domain.executor.SchedulerProvider
import com.anil_shatharashi.clean.mvvm.domain.gateway.TasksNetworkGateway
import com.anil_shatharashi.clean.mvvm.domain.model.Task
import com.anil_shatharashi.clean.mvvm.domain.usecases.base.SingleUsecase
import io.reactivex.Single

class GetTaskListUseCase (private val anyApiGateway: TasksNetworkGateway, scheduler: SchedulerProvider)
    : SingleUsecase<Any, List<Int>>(scheduler) {
    override fun buildUseCase(params: Any): Single<List<Int>> = anyApiGateway.getTasks()
}

class GetTaskDetailsUseCase (private val anyApiGateway: TasksNetworkGateway, scheduler: SchedulerProvider)
    : SingleUsecase<Int, Task>(scheduler) {
    override fun buildUseCase(params: Int): Single<Task> = anyApiGateway.getTaskDetail(params)
}