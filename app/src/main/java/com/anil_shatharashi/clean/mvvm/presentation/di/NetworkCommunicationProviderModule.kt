package com.anil_shatharashi.clean.mvvm.presentation.di

import android.app.Application
import com.anil_shatharashi.clean.mvvm.data.executor.ThreadSchedulerProvider
import com.anil_shatharashi.clean.mvvm.data.source.api.AnyApi
import com.anil_shatharashi.clean.mvvm.domain.executor.SchedulerProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkCommunicationProviderModule {

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .baseUrl(AnyApi.BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideAnyApi(retrofit: Retrofit): AnyApi? = retrofit.create(AnyApi::class.java)

    @Provides
    @Singleton
    fun provideThreadSchedulerProvider(): SchedulerProvider = ThreadSchedulerProvider()
}
