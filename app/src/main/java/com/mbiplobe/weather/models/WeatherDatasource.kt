package com.mbiplobe.weather.models

import com.mbiplobe.weather.data.OperationCallback

interface WeatherDatasource {
    fun retrieveWeather(callback: OperationCallback<WeatherModel>)
    fun cancel()
}