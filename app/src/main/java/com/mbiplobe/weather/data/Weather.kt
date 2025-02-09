package com.mbiplobe.weather.data

data class Weather(
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Double,
    val humidity: Int,
    val seaLevel: Int,
    val grndLevel: Int,
    val country: String,
    val sunrise: Int,
    val sunset: Int,
    val main: String,
    val description: String,
    val icon: String,
    val speed: Double,
    val visibility: Int,
    val name: String
)