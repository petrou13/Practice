package com.example.practice.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "8ab72bdfc20efd0e159b98d001f704b8"

//https://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=8ab72bdfc20efd0e159b98d001f704b8&lang=en

interface OpenWeatherAPI {

    @GET("weather")
    fun getCurrentWeather(
        @Query("q") location: String,  //город
        @Query("lang") languageCode: String = "ru" //используемый язык
    ): Deferred<CurrentWeatherJSON>  //выполнение асинхронно

    companion object{  //вместо OpenWeatherAPI.invoke() можно теперь писать только OpenWeatherAPI()
        operator fun invoke(): OpenWeatherAPI{
             val requestInterceptor = Interceptor {chain ->    //используем перехватчик, чтобы добавить к ссылке ключ
                val url = chain.request()  //переходим на ключ
                    .url()
                    .newBuilder()
                    .addQueryParameter("appid", API_KEY)
                    .build()
                 val request = chain.request()  //копируем ключ
                     .newBuilder()
                     .url(url)
                     .build()

                 return@Interceptor chain.proceed(request)
             }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory()) //из-за deffered
                .addConverterFactory(GsonConverterFactory.create())  //конвертирование json в gson, чтобы с ним можно было дальше работать в котлине
                .build()
                .create(OpenWeatherAPI::class.java)
        }
    }

}
