package com.example.practice.data.dbase.weather

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_WEATHER_ID = 0

@Entity(tableName = "current_weather")
data class CurrentWeatherJSON(
    @Embedded(prefix = "main_")
    val main: Main,
    val name: String,
    @Embedded(prefix = "weather_")
    val weather: List<Weather>,
    @Embedded(prefix = "wind_")
    val wind: Wind
){
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_WEATHER_ID
}