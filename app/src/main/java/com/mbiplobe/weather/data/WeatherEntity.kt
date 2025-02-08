package com.mbiplobe.weather.data

data class WeatherEntity(
    var temp: Double,
    var feelsLike: Double,
    var tempMin: Double,
    var tempMax: Double,
    var pressure: Double,
    var humidity: Int,
    var seaLevel: Int,
    var grandLevel: Int,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
    var main: String? = null,
    var description: String? = null,
    var icon: String? = null,
    var speed: Double,
    val visibility: Int,
    val name: String
)
