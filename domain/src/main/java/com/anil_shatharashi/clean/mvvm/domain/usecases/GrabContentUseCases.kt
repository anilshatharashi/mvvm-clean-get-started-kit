package com.anil_shatharashi.clean.mvvm.domain.usecases

import com.anil_shatharashi.clean.mvvm.domain.executor.SchedulerProvider
import com.anil_shatharashi.clean.mvvm.domain.gateway.AnyApiGateway
import com.anil_shatharashi.clean.mvvm.domain.model.Task
import com.anil_shatharashi.clean.mvvm.domain.usecases.base.SingleUsecase
import io.reactivex.Single
import javax.inject.Inject

class GetTaskListUseCase @Inject constructor(private val anyApiGateway: AnyApiGateway, scheduler: SchedulerProvider)
    : SingleUsecase<Any, List<Int>>(scheduler) {
    override fun buildUseCase(params: Any): Single<List<Int>> = anyApiGateway.getOpportunitiesTasks()
}

class GetTaskDetailsUseCase @Inject constructor(private val anyApiGateway: AnyApiGateway, scheduler: SchedulerProvider)
    : SingleUsecase<Int, Task>(scheduler) {
    override fun buildUseCase(params: Int): Single<Task> = anyApiGateway.getTaskDetail(params)
}