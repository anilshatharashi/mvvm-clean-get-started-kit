package com.anil_shatharashi.clean.mvvm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anil_shatharashi.clean.mvvm.domain.model.Task
import com.anil_shatharashi.clean.mvvm.domain.usecases.GetTaskDetailsUseCase
import javax.inject.Inject

class TaskDetailViewModel @Inject constructor(private val getTaskDetailsUseCase: GetTaskDetailsUseCase) : ViewModel() {
    private val task = MutableLiveData<Task>()

    val observableTask: LiveData<Task>
        get() = task

    fun getTask(id: Int) {
    }
}