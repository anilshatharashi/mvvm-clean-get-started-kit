package com.anil_shatharashi.clean.mvvm.data.repository

import com.anil_shatharashi.clean.mvvm.data.source.api.AnyApi
import com.anil_shatharashi.clean.mvvm.domain.gateway.AnyApiGateway
import com.anil_shatharashi.clean.mvvm.domain.model.Task
import io.reactivex.Single
import javax.inject.Inject

class AnyApiRepository @Inject constructor(private val anyAnyApi: AnyApi) : AnyApiGateway {
    override fun getOpportunitiesTasks(): Single<List<Int>> = anyAnyApi.getOpportunitiesTasks()

    override fun getTaskDetail(taskId: Int): Single<Task> = anyAnyApi.getTaskDetails(taskId)
}