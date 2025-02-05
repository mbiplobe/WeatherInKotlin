package com.mbiplobe.weather.models

import com.mbiplobe.weather.data.OperationCallback
import com.mbiplobe.weather.data.WeatherResponse

class WeatherRepsitoryImp(private val weatherDatasource: WeatherDatasource): WeatherRepository {

    override fun fetchMuseums(callback: OperationCallback<WeatherModel>) {
        weatherDatasource.retrieveWeather(callback)
    }

    override fun cancel() {
        weatherDatasource.cancel()
    }

}