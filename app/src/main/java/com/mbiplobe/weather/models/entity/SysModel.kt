package com.mbiplobe.weather.models.entity

import com.google.gson.annotations.SerializedName

data class SysModel(
    @SerializedName("country") val country: String,
    @SerializedName("sunrise") val sunrise: Long,
    @SerializedName("sunset") val sunset: Long

)
