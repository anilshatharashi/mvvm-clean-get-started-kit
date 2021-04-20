package com.anil_shatharashi.clean.mvvm.presentation.di

import com.anil_shatharashi.clean.mvvm.presentation.ui.taskdetail.TaskDetailFragment
import com.anil_shatharashi.clean.mvvm.presentation.ui.tasklist.TaskListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkCommunicationProviderModule::class,
        RepositoryModule::class, ViewModelModule::class]
)
interface ApplicationComponent {
    fun inject(taskListFragment: TaskListFragment)
    fun inject(taskDetailFragment: TaskDetailFragment)
}
