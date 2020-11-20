package com.example.practice.data

import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "8ab72bdfc20efd0e159b98d001f704b8"

//api.openweathermap.org/data/2.5/weather?q=Moscow&appid=8ab72bdfc20efd0e159b98d001f704b8&Lang=en

interface OpenWeatherAPI {

    @GET("current.json")
    fun getCurrentWeather(
        @Query("q") location: String,
        @Query("lang") languageCode: String = "en"
    ): Deffered<CurrentWeatherJSON>
}