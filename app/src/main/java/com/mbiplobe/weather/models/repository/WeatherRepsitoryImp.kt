package com.mbiplobe.weather.models.repository

import com.mbiplobe.weather.data.OperationCallback
import com.mbiplobe.weather.data.Weather
import com.mbiplobe.weather.models.listener.WeatherDatasource

class WeatherRepsitoryImp(private val weatherDatasource: WeatherDatasource): WeatherRepository {

    override fun fetchMuseums(callback: OperationCallback<Weather>) {
        weatherDatasource.retrieveWeather(callback)
    }

    override fun cancel() {
        weatherDatasource.cancel()
    }

}