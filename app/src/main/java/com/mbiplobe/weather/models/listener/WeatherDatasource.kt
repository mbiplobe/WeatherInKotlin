package com.mbiplobe.weather.models.listener

import com.mbiplobe.weather.data.OperationCallback
import com.mbiplobe.weather.data.Weather

interface WeatherDatasource {
    fun retrieveWeather(callback: OperationCallback<Weather>)
    fun cancel()
}