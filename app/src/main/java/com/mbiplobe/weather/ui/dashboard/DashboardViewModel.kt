package com.mbiplobe.weather.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mbiplobe.weather.data.OperationCallback
import com.mbiplobe.weather.models.WeatherModel
import com.mbiplobe.weather.models.WeatherRepository

class DashboardViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val _museums = MutableLiveData<WeatherModel>()
    val weather: LiveData<WeatherModel> = _museums

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    private val _isEmptyEmptyUpdate = MutableLiveData<Boolean>()
    val isEmptyList: LiveData<Boolean> = _isEmptyEmptyUpdate

   fun getWeatherUpdate(){
        _isViewLoading.value = true
        repository.fetchMuseums(object : OperationCallback<WeatherModel> {
            override fun onSuccess(data: WeatherModel?) {
                _isViewLoading.value = false
                if (data==null) {
                    _isEmptyEmptyUpdate.value = true

                } else {
                    _museums.value = data?:null
                }
            }

            override fun onError(error: String?) {
                _isViewLoading.value = false
                _onMessageError.value = error?: "Unknown error"
            }

        })
    }
}