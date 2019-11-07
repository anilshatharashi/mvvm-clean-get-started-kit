package com.anil_shatharashi.clean.mvvm.data.executor

import com.anil_shatharashi.clean.mvvm.domain.executor.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ThreadSchedulerProvider : SchedulerProvider {

    override fun mainThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun backgroundThread(): Scheduler {
        return Schedulers.io()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }
}