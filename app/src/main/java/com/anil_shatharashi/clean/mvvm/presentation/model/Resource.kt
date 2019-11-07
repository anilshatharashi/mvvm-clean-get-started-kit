package com.anil_shatharashi.clean.mvvm.presentation.model

enum class Status {
    SUCCESS,
    ERROR,
    LOADING,
    INIT
}

data class Resource<out T>(val status: Status, val data: T?, val errorMessage: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(errorMessage: String? = null): Resource<T> {
            return Resource(Status.ERROR,null, errorMessage)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }

        fun <T> init(): Resource<T> {
            return Resource(Status.INIT, null, null)
        }
    }
}
