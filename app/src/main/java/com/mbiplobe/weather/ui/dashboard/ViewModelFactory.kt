package com.mbiplobe.weather.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mbiplobe.weather.models.repository.WeatherRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: WeatherRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DashboardViewModel(repository) as T
    }
}