package com.foster.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

public class WeatherListActivity : AppCompatActivity() {


    private lateinit var binding : ActivityWeatherListBinding
    lateinit var adapter : WeatherAdapter
    val TAG = "WeatherListActivity"

    override fun onCreate(savedInstanseState: Bundle?) {
        super.onCreate(savedInstanseState)
        binding = ActivityWeatherListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var weatherList = listOf<WeatherInfo>()




        val weatherApi = RetrofitHelper.getInstance().create(WeatherService::class.java)
        val weatherCall = weatherApi.getWeather()


        weatherCall.enqueue(object : Callback<List<WeatherInfo>> {
            override fun onResponse(
                call: Call<List<WeatherInfo>>,
                response: Response<List<WeatherInfo>>
            ) {
                Log.d(TAG, "onResponse: ${response.body()}")
                weatherList = response.body() ?: listOf<WeatherInfo>()
                adapter = WeatherAdapter(weatherList)
                binding.recyclerViewWeatherList.adapter = adapter
                binding.recyclerViewWeatherList.layoutManager = LinearLayoutManager(this@WeatherListActivity)
            }

            override fun onFailure(call: Call<List<WeatherInfo>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }

        })









    }




}
