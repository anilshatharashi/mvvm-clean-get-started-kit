package com.anil_shatharashi.clean.mvvm

import androidx.multidex.MultiDexApplication
import com.anil_shatharashi.clean.mvvm.presentation.di.appModule
import com.anil_shatharashi.clean.mvvm.presentation.di.dataModule
import com.anil_shatharashi.clean.mvvm.presentation.di.domainModule
import com.anil_shatharashi.clean.mvvm.presentation.di.useCasesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

open class ListAndDetailsApplication : MultiDexApplication()  {

    protected val appComponent: MutableList<Module> = mutableListOf(useCasesModule, appModule, domainModule, dataModule)

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(appComponent)
        }
    }

}
