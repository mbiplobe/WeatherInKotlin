package com.mbiplobe.weather.injects

import com.mbiplobe.weather.data.ApiClient
import com.mbiplobe.weather.data.RemoteWeatherDataSource
import com.mbiplobe.weather.models.listener.WeatherDatasource
import com.mbiplobe.weather.models.repository.WeatherRepository
import com.mbiplobe.weather.models.repository.WeatherRepsitoryImp
import com.mbiplobe.weather.ui.dashboard.ViewModelFactory

object Injects {
    private var weatherDatasource: WeatherDatasource? = null
    private var weatherRepository: WeatherRepsitoryImp? = null
    private var viewModelFactory: ViewModelFactory? = null

    private fun createWeatherDataSource(): WeatherDatasource {
        val dataSource = RemoteWeatherDataSource(ApiClient)
        weatherDatasource = dataSource
        return dataSource
    }

    private fun createRepository(): WeatherRepository {
        val repository = WeatherRepsitoryImp(provideDataSource())
        weatherRepository = repository
        return repository
    }

    private fun createViewModelFactory(): ViewModelFactory {
        val viewModel = ViewModelFactory(providerRepository())
        viewModelFactory = viewModel
        return viewModel
    }

    private fun provideDataSource() = weatherDatasource ?: createWeatherDataSource()
    private fun providerRepository() = weatherRepository ?: createRepository()
    fun providerViewModelFactory() = viewModelFactory ?: createViewModelFactory()

    fun cancel() {
        weatherDatasource = null
        weatherRepository = null
        viewModelFactory = null
    }


}