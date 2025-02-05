package com.mbiplobe.weather.models

import com.mbiplobe.weather.data.OperationCallback
import com.mbiplobe.weather.data.WeatherResponse

interface WeatherRepository {
    fun fetchMuseums(callback: OperationCallback<WeatherModel>)
    fun cancel()
}