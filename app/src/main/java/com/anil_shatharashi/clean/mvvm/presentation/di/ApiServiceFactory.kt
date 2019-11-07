package com.anil_shatharashi.clean.mvvm.presentation.di

import com.anil_shatharashi.clean.mvvm.data.source.api.AnyApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://esi.evetech.net/"

object ApiServiceFactory {

    fun createAnyApiService(isDebug: Boolean): AnyApi {
        val okHttpClient = createOkHttpClient(createLoggingInterceptor(isDebug))
        return createAnyApiService(okHttpClient)
    }

    private fun createAnyApiService(okHttpClient: OkHttpClient): AnyApi {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build().create(AnyApi::class.java)
    }

    private fun createOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
    }

    private fun createLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (isDebug)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return logging
    }

}