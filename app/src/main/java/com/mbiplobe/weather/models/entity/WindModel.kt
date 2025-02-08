package com.mbiplobe.weather.models.entity

import com.google.gson.annotations.SerializedName

data class WindModel(
    @SerializedName("speed") var speed: Double,
    @SerializedName("deg") var deg: Int
)