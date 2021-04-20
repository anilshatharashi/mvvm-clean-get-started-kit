package com.anil_shatharashi.clean.mvvm.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.anil_shatharashi.clean.mvvm.domain.usecases.GetTaskListUseCase
import com.anil_shatharashi.clean.mvvm.presentation.model.Resource
import javax.inject.Inject

open class TaskListViewModel @Inject constructor(private val getTaskListUseCase: GetTaskListUseCase) : RxViewModel() {
    val taskListLiveData = MutableLiveData<Resource<List<Int>>>()

    open fun loadListOfTasks() {
        compositeDisposable.add(getTaskListUseCase.execute(Any())
                .subscribe({ tasks ->
                    taskListLiveData.value = Resource.success(tasks)
                }, { taskListLiveData.value = Resource.error("Error in fetching Tasks") }))
    }
}