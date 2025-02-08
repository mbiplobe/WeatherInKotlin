package com.mbiplobe.weather.models

import com.google.gson.annotations.SerializedName


data class WeatherModel(
    @SerializedName("base")val base: String,
    @SerializedName("timezone")val timezone: String,
    @SerializedName("visibility")val visibility: Int,
    @SerializedName("id")val id: Int,
    @SerializedName("name")val name: String,
    @SerializedName("cod")val cod: Int,
    @SerializedName("weather")val weather: WeatherDescriptionModel?

)