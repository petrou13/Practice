package com.example.practice.data.dbase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.practice.data.dbase.weather.CurrentWeatherJSON

@Database(
    entities = [CurrentWeatherJSON::class],
    version = 1
)
abstract class WeatherDataBase : RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao

    companion object {
        @Volatile var instance : WeatherDataBase? = null
        private val LOCK = Any()  //для устранения проблем с потоками

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also{ instance = instance }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                WeatherDataBase::class.java, "weather.db")
    }
}