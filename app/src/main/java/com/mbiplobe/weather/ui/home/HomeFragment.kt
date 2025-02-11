package com.mbiplobe.weather.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.mbiplobe.weather.data.Weather
import com.mbiplobe.weather.databinding.FragmentHomeBinding
import com.mbiplobe.weather.injects.Injects
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val viewModel by viewModels<HomeViewModel> {
        Injects.providerViewModelFactory()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupViewModel()
        return root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getWeatherUpdate()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Injects.cancel()
        _binding = null

    }




    private val renderWeather = Observer<Weather> {

        binding.progressbarIndicator.visibility = View.GONE
        binding.errorMsgTv.visibility = View.GONE
        binding.contentView.visibility = View.VISIBLE

        viewBind(it)

    }



    private fun viewBind(weather: Weather) {

        binding.locationTv.text = weather.name
//        binding.root.weather_update_im = String.format("0.2%",weather.feelsLike)

        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val currentDate = dateFormat.format(calendar.time)

        binding.dateTv.text = currentDate
        binding.temparatureTv.text ="${weather.temp}"
        binding.weatherTitleTv.text = weather.main
        binding.windSpeedTv.text ="${weather.speed}"
        binding.humTv.text = "${weather.humidity}"
    }

    private fun setupViewModel() {
        viewModel.weather.observe(viewLifecycleOwner, renderWeather)
        viewModel.isViewLoading.observe(viewLifecycleOwner, isViewLoadingObserver)
        viewModel.onMessageError.observe(viewLifecycleOwner, onMessageErrorObserver)
        viewModel.isEmptyList.observe(viewLifecycleOwner, emptyListObserver)
    }

    private val isViewLoadingObserver = Observer<Boolean> {
        val visibility = if (it) View.VISIBLE else View.GONE
        binding.progressbarIndicator.visibility = visibility
        binding.errorMsgTv.visibility = View.GONE
        binding.contentView.visibility = View.GONE
//        binding.progressbarIndicator.visibility = View.GONE

    }

    private val onMessageErrorObserver = Observer<Any> {
//        error_msg.visibility = View.VISIBLE
        binding.errorMsgTv.visibility = View.VISIBLE
        val message = "Error $it"
        binding.errorMsgTv.text = message
        binding.contentView.visibility = View.GONE
        binding.progressbarIndicator.visibility = View.GONE

    }

    private val emptyListObserver = Observer<Boolean> {
//        layoutEmpty.visibility = View.VISIBLE
        binding.errorMsgTv.visibility = View.VISIBLE
        val message = "No Error"
        binding.errorMsgTv.text = message
        binding.contentView.visibility = View.GONE
        binding.progressbarIndicator.visibility = View.GONE

    }
}