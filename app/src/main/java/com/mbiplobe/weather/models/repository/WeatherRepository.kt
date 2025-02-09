package com.mbiplobe.weather.models.repository

import com.mbiplobe.weather.data.OperationCallback
import com.mbiplobe.weather.data.Weather


interface WeatherRepository {
    fun fetchMuseums(callback: OperationCallback<Weather>)
    fun cancel()
}