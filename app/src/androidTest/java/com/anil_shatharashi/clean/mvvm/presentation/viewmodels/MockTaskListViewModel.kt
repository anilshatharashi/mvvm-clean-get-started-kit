package com.anil_shatharashi.clean.mvvm.presentation.viewmodels

import com.anil_shatharashi.clean.mvvm.domain.usecases.GetTaskListUseCase
import com.anil_shatharashi.clean.mvvm.presentation.model.Resource
import com.anil_shatharashi.clean.mvvm.presentation.viewmodel.TaskListViewModel

class MockTaskListViewModel(getTaskListUseCase: GetTaskListUseCase)
    : TaskListViewModel(getTaskListUseCase) {

    override fun loadListOfTasks() {
        taskListLiveData.postValue(Resource.success(listOf(2, 9, 10, 12, 13, 15)))
    }
}