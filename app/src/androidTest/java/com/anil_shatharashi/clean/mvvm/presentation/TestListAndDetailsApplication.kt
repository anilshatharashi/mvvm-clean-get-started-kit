package com.anil_shatharashi.clean.mvvm.presentation

import com.anil_shatharashi.clean.mvvm.ListAndDetailsApplication
import com.anil_shatharashi.clean.mvvm.presentation.viewmodel.TaskListViewModel
import com.anil_shatharashi.clean.mvvm.presentation.viewmodels.MockTaskListViewModel
import io.mockk.mockk
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class TestListAndDetailsApplication : ListAndDetailsApplication() {

    private val mockViewModelModule = module(override = true) {
        viewModel<TaskListViewModel> { MockTaskListViewModel(mockk(), mockk(), mockk()) }
    }

    private val testAppComponent: MutableList<Module> = mutableListOf(mockViewModelModule)

    override fun onCreate() {
        appComponent.addAll(testAppComponent)
        super.onCreate()
    }
}