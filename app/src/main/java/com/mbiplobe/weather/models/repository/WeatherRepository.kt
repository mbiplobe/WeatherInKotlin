package com.mbiplobe.weather.models.repository

import com.mbiplobe.weather.data.OperationCallback
import com.mbiplobe.weather.models.entity.WeatherModel

interface WeatherRepository {
    fun fetchMuseums(callback: OperationCallback<WeatherModel>)
    fun cancel()
}