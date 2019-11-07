package com.anil_shatharashi.clean.mvvm.presentation.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class RxViewModel(protected val compositeDisposable: CompositeDisposable = CompositeDisposable()) : ViewModel() {

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun clearObservables() {
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}