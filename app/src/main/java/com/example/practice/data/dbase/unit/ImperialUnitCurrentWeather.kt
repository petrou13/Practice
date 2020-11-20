package com.example.practice.data.dbase.unit

import androidx.room.ColumnInfo

data class ImperialUnitCurrentWeather (
    @ColumnInfo(name = "feelsLikeF")
    override val feelsLikeTemperature: Double,
    @ColumnInfo(name = "tempF")
    override val temperature: Double,
    @ColumnInfo(name = "tempMaxF")
    override val temperatureMax: Double,
    @ColumnInfo(name = "tempMinF")
    override val temperatureMin: Double,
    @ColumnInfo(name = "cityName")
    override val cityName: String,
    @ColumnInfo(name = "weatherIcon")
    override val weatherIcon: String,
    @ColumnInfo(name = "weatherMain")
    override val weatherMain: String,
    @ColumnInfo(name = "windDeg")
    override val windDeg: Int,
    @ColumnInfo(name = "windMph")
    override val windSpeed: Int

) : UnitCurrentWeather