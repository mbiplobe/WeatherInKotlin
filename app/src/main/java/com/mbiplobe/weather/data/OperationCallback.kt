package com.mbiplobe.weather.data

interface OperationCallback<T> {
    fun onSuccess(data: T?)
    fun onError(error: String?)
}