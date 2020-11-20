package com.example.practice.data.dbase

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.practice.data.dbase.unit.ImperialUnitCurrentWeather
import com.example.practice.data.dbase.unit.MetricUnitCurrentWeather
import com.example.practice.data.dbase.weather.CURRENT_WEATHER_ID
import com.example.practice.data.dbase.weather.CurrentWeatherJSON

interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUpdate(weatherEntry: CurrentWeatherJSON)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricUnitCurrentWeather>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialUnitCurrentWeather>
}