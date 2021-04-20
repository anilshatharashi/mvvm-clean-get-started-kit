package com.anil_shatharashi.clean.mvvm

import android.app.Application
import com.anil_shatharashi.clean.mvvm.presentation.di.*

open class ListAndDetailsApplication : Application() {

    companion object {
        lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .provideApplication(this)
    }

}
