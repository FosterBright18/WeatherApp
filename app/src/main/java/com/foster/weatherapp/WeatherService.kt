package com.foster.weatherapp;

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("api.pl")

    fun getWeather(@Query("lon") lon : String = "34.110617446889165",
                   @Query("lat") lat : String = "-118.15427797408164",
                   @Query("product") product : String = "two",
                   @Query("output") output : String = "json") : Call<List<WeatherInfo>>
}