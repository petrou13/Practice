package com.example.practice

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practice.data.OpenWeatherAPI
import kotlinx.android.synthetic.main.cur_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class curWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = curWeatherFragment()
    }

    private lateinit var viewModel: CurWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cur_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurWeatherViewModel::class.java)
        // TODO: Use the ViewModel

        val apiService = OpenWeatherAPI()

        GlobalScope.launch(Dispatchers.Main) {                                                        //так делать не надо, ТОЛЬКО ДЛЯ ТЕСТА
            val currentWeatherJSON = apiService.getCurrentWeather("Moscow").await()
            txtWeather.text = currentWeatherJSON.toString()
        }
    }

}