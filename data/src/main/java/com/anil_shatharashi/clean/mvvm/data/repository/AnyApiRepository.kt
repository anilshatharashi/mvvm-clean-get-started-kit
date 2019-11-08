package com.anil_shatharashi.clean.mvvm.data.repository

import com.anil_shatharashi.clean.mvvm.data.repository.remote.api.AnyApi
import com.anil_shatharashi.clean.mvvm.domain.gateway.TasksNetworkGateway
import com.anil_shatharashi.clean.mvvm.domain.model.Task
import io.reactivex.Single

class AnyApiRepository(private val anyAnyApi: AnyApi) : TasksNetworkGateway {

    override fun getTasks(): Single<List<Int>> = anyAnyApi.getTasks()

    override fun getTaskDetail(taskId: Int): Single<Task> = anyAnyApi.getTaskDetails(taskId)
}