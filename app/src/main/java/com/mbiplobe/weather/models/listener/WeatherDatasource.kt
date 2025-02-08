package com.mbiplobe.weather.models.listener

import com.mbiplobe.weather.data.OperationCallback
import com.mbiplobe.weather.models.entity.WeatherModel

interface WeatherDatasource {
    fun retrieveWeather(callback: OperationCallback<WeatherModel>)
    fun cancel()
}