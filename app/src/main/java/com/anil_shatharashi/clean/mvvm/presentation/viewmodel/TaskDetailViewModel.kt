package com.jshvarts.notesnavigation.presentation.notedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anil_shatharashi.clean.mvvm.domain.model.Task
import com.anil_shatharashi.clean.mvvm.domain.usecases.GetTaskDetailsUseCase

class TaskDetailViewModel(private val getTaskDetailsUseCase: GetTaskDetailsUseCase) : ViewModel() {
    private val task = MutableLiveData<Task>()

    val observableTask: LiveData<Task>
        get() = task

    fun getTask(id: Int) {
    }
}