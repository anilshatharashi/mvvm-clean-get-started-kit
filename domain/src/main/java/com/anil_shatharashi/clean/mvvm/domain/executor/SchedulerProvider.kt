package com.anil_shatharashi.clean.mvvm.domain.executor

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun mainThread(): Scheduler
    fun backgroundThread(): Scheduler
    fun computation(): Scheduler
}