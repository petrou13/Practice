package com.example.practice.data.dbase.unit

interface UnitCurrentWeather {
    val feelsLikeTemperature: Double
    val temperature: Double
    val temperatureMax: Double
    val temperatureMin: Double
    val cityName: String
    val weatherIcon: String
    val weatherMain: String
    val windDeg: Int
    val windSpeed: Int
}