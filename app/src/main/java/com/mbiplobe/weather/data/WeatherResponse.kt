package com.mbiplobe.weather.data

import com.mbiplobe.weather.models.entity.WeatherModel


data class WeatherResponse(val code: Int?, val message: String?, val data: WeatherModel?) {
    fun isSuccess(): Boolean = (code == 200)
}