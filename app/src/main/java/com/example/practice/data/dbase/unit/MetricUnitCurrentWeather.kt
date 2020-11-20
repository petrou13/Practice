package com.example.practice.data.dbase.unit

import androidx.room.ColumnInfo

data class MetricUnitCurrentWeather (
    @ColumnInfo(name = "feelsLikeC")
    override val feelsLikeTemperature: Double,
    @ColumnInfo(name = "tempC")
    override val temperature: Double,
    @ColumnInfo(name = "tempMaxC")
    override val temperatureMax: Double,
    @ColumnInfo(name = "tempMinC")
    override val temperatureMin: Double,
    @ColumnInfo(name = "cityName")
    override val cityName: String,
    @ColumnInfo(name = "weatherIcon")
    override val weatherIcon: String,
    @ColumnInfo(name = "weatherMain")
    override val weatherMain: String,
    @ColumnInfo(name = "windDeg")
    override val windDeg: Int,
    @ColumnInfo(name = "windMps")
    override val windSpeed: Int

): UnitCurrentWeather