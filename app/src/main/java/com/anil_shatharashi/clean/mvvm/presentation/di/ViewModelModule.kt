package com.anil_shatharashi.clean.mvvm.presentation.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anil_shatharashi.clean.mvvm.presentation.di.qualifiers.ViewModelKey
import com.anil_shatharashi.clean.mvvm.presentation.viewmodel.TaskDetailViewModel
import com.anil_shatharashi.clean.mvvm.presentation.viewmodel.TaskListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TaskListViewModel::class)
    abstract fun bindTaskListViewModel(taskListViewModel: TaskListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TaskDetailViewModel::class)
    abstract fun bindTaskDetailsViewModel(taskDetailViewModel: TaskDetailViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
