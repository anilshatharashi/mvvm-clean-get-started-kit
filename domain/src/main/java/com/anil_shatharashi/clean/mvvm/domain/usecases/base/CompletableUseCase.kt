package com.anil_shatharashi.clean.mvvm.domain.usecases.base

import com.anil_shatharashi.clean.mvvm.domain.executor.PostExecutionThread
import com.anil_shatharashi.clean.mvvm.domain.executor.ThreadExecutor
import io.reactivex.Completable
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers

abstract class CompletableUseCase<in Params>(
        private val threadExecutor: ThreadExecutor,
        private val postExecutionThread: PostExecutionThread) {

    private val subscription = Disposables.empty()

    protected abstract fun buildUseCaseObservable(params: Params): Completable

    fun execute(params: Params): Completable {
        return this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
    }

    fun unsubscribe() {
        if (!subscription.isDisposed) {
            subscription.dispose()
        }
    }

}