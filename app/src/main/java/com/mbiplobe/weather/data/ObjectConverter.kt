package com.mbiplobe.weather.data

import com.mbiplobe.weather.models.entity.WeatherModel

object ObjectConverter {
    fun WeatherModelToWeather(weatherModel: WeatherModel) = Weather(
        weatherModel.main?.temp ?: 0.0,
        weatherModel.main?.feelsLike ?: 0.0,
        weatherModel.main?.tempMin ?: 0.0,
        weatherModel.main?.tempMax ?: 0.0,
        weatherModel.main?.pressure ?: 0.0,
        weatherModel.main?.humidity ?: 0,
        weatherModel.main?.seaLevel ?: 0,
        weatherModel.main?.grndLevel ?: 0,
        weatherModel.sysModel?.country ?: "",
        weatherModel.sysModel?.sunrise ?: 0,
        weatherModel.sysModel?.sunset ?: 0,
        weatherModel.weather?.get(0)?.main?: "",
        weatherModel.weather?.get(0)?.description?: "",
        weatherModel.weather?.get(0)?.icon?: "",
        weatherModel.wind?.speed ?: 0.0,
        weatherModel.visibility,
        weatherModel.name
    )

}