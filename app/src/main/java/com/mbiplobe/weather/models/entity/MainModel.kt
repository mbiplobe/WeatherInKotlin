package com.mbiplobe.weather.models.entity

import com.google.gson.annotations.SerializedName

data class MainModel (
    @SerializedName("temp") var temp: Double,
    @SerializedName("feels_like") var feelsLike: Double,
    @SerializedName("temp_min") var tempMin: Double,
    @SerializedName("temp_max") var tempMax: Double,
    @SerializedName("pressure") var pressure: Double,
    @SerializedName("humidity") var humidity: Int,
    @SerializedName("sea_level") var seaLevel: Int,
    @SerializedName("grnd_level") var grndLevel: Int
)
