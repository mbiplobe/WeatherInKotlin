package com.mbiplobe.weather.data

import com.mbiplobe.weather.models.WeatherDatasource
import com.mbiplobe.weather.models.WeatherModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteWeatherDataSource(apiClient: ApiClient) : WeatherDatasource {
    private var call: Call<WeatherModel>? = null
    private val service = apiClient.build()

    override fun retrieveWeather(callback: OperationCallback<WeatherModel>) {
        call = service?.weather(52.52,13.41, "c15646613c5b5b7a89f764b00b96c709")
        call?.enqueue(object : Callback<WeatherModel>{
            override fun onResponse(p0: Call<WeatherModel>, response: Response<WeatherModel>) {
                response.body()?.let {
                    if (response.isSuccessful) {
                        val test= response.body()
                        callback.onSuccess(response.body())
                    } else {
                        callback.onError(response.message())
                    }
                }
            }

            override fun onFailure(p0: Call<WeatherModel>, p1: Throwable) {
                callback.onError(p1.message)
            }

        }

        )
    }

    override fun cancel() {

    }

}