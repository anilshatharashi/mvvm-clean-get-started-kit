package com.anil_shatharashi.clean.mvvm.presentation.di

import android.content.Context
import androidx.room.Room
import com.anil_shatharashi.clean.mvvm.data.repository.local.CleanMVVMDemoDatabase

object DatabaseFactory {

    fun getDBInstance(context: Context) = Room.databaseBuilder(context, CleanMVVMDemoDatabase::class.java, "CleanMVVMDemoDatabase")
            .fallbackToDestructiveMigration()
            .build()
}