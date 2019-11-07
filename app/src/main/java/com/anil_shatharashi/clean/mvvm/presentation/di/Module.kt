package com.anil_shatharashi.clean.mvvm.presentation.di

import com.anil_shatharashi.clean.mvvm.BuildConfig
import com.anil_shatharashi.clean.mvvm.data.executor.ThreadSchedulerProvider
import com.anil_shatharashi.clean.mvvm.data.repository.AnyApiRepository
import com.anil_shatharashi.clean.mvvm.domain.executor.SchedulerProvider
import com.anil_shatharashi.clean.mvvm.domain.gateway.AnyApiGateway
import com.anil_shatharashi.clean.mvvm.domain.usecases.GetTaskDetailsUseCase
import com.anil_shatharashi.clean.mvvm.domain.usecases.GetTaskListUseCase
import com.anil_shatharashi.clean.mvvm.presentation.viewmodel.TaskListViewModel
import com.jshvarts.notesnavigation.presentation.notedetail.TaskDetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    viewModel { TaskListViewModel(get()) }
    viewModel { TaskDetailViewModel(get()) }
}

val useCasesModule = module {
    factory { GetTaskListUseCase(get(), get()) }
    factory { GetTaskDetailsUseCase (get(), get()) }
}

val domainModule = module {
    single { ThreadSchedulerProvider() as SchedulerProvider }
}

val dataModule = module {
    single(named("AnyApi")) { ApiServiceFactory.createAnyApiService(BuildConfig.DEBUG) }

    single<AnyApiGateway> { AnyApiRepository(get(named("AnyApi"))) }

}