package com.anil_shatharashi.clean.mvvm.data.source.api

import com.anil_shatharashi.clean.mvvm.domain.model.Task
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AnyApi {

    @GET("/v1/opportunities/tasks/")
    fun getOpportunitiesTasks(): Single<List<Int>>

    @GET("/v1/opportunities/tasks/")
    fun getTaskDetails(@Query("task_id")taskId: Int): Single<Task>
}
