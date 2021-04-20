package com.anil_shatharashi.clean.mvvm.presentation.di

import com.anil_shatharashi.clean.mvvm.domain.usecases.GetTaskDetailsUseCase
import com.anil_shatharashi.clean.mvvm.domain.usecases.GetTaskListUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetTaskListUseCase(getTaskListUseCase: GetTaskListUseCase): GetTaskListUseCase

    @Binds
    abstract fun bindGetTaskDetailsUseCase(getTaskDetailsUseCase: GetTaskDetailsUseCase): GetTaskDetailsUseCase

}
