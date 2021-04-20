package com.anil_shatharashi.clean.mvvm.presentation.di

import com.anil_shatharashi.clean.mvvm.data.repository.AnyApiRepository
import com.anil_shatharashi.clean.mvvm.data.source.api.AnyApi
import com.anil_shatharashi.clean.mvvm.domain.gateway.AnyApiGateway
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAnyApiRepository(anyApiRepository: AnyApiRepository): AnyApiGateway


}
