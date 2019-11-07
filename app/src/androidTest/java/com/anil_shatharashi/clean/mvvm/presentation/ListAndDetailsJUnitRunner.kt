package com.anil_shatharashi.clean.mvvm.presentation

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class ListAndDetailsJUnitRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, TestListAndDetailsApplication::class.java.name, context)
    }
}
