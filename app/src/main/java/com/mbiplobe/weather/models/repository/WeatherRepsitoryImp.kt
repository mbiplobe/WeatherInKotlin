package com.mbiplobe.weather.models.repository

import com.mbiplobe.weather.data.OperationCallback
import com.mbiplobe.weather.models.listener.WeatherDatasource
import com.mbiplobe.weather.models.entity.WeatherModel

class WeatherRepsitoryImp(private val weatherDatasource: WeatherDatasource): WeatherRepository {

    override fun fetchMuseums(callback: OperationCallback<WeatherModel>) {
        weatherDatasource.retrieveWeather(callback)
    }

    override fun cancel() {
        weatherDatasource.cancel()
    }

}