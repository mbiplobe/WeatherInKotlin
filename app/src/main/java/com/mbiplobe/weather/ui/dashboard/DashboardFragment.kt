package com.mbiplobe.weather.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.mbiplobe.weather.R
import com.mbiplobe.weather.data.Weather
import com.mbiplobe.weather.injects.Injects

class DashboardFragment : Fragment() {
    private lateinit var cardView: CardView
    private lateinit var error_msg: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var lat_text: TextView
    private lateinit var lon_text: TextView


    private val viewModel by viewModels<DashboardViewModel> {
        Injects.providerViewModelFactory()
    }

    private val renderWeather = Observer<Weather> {
        error_msg.visibility = View.GONE
        progressBar.visibility = View.GONE
        bindView(it)

    }


    private fun bindView(weather: Weather) {
        lat_text.text = String.format("0.2%",weather.feelsLike)
        lon_text.text = String.format("0.2%",weather.temp)
    }

    private fun setupViewModel() {
        viewModel.weather.observe(viewLifecycleOwner, renderWeather)
        viewModel.isViewLoading.observe(viewLifecycleOwner, isViewLoadingObserver)
        viewModel.onMessageError.observe(viewLifecycleOwner, onMessageErrorObserver)
        viewModel.isEmptyList.observe(viewLifecycleOwner, emptyListObserver)
    }

    private val isViewLoadingObserver = Observer<Boolean> {
        val visibility = if (it) View.VISIBLE else View.GONE
        progressBar.visibility = visibility
    }

    private val onMessageErrorObserver = Observer<Any> {
        error_msg.visibility = View.VISIBLE
//        layoutEmpty.visibility = View.GONE
//        textViewError.text = "Error $it"
    }

    private val emptyListObserver = Observer<Boolean> {
//        layoutEmpty.visibility = View.VISIBLE
        error_msg.visibility = View.GONE
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        setupViewModel()
        setView(view)

        return view
    }

    override fun onResume() {
        super.onResume()
        viewModel.getWeatherUpdate()
    }

    private fun setView(view: View) {
        progressBar = view.findViewById(R.id.progress_bar)
        error_msg = view.findViewById(R.id.error_msg)
        cardView = view.findViewById(R.id.card_view)
        lat_text = view.findViewById(R.id.lat_text)
        lon_text = view.findViewById(R.id.lon_text)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Injects.cancel()
        //_binding = null
    }
}