package com.foster.weatherapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class WeatherInfo(val time : Integer, val minTemp : Integer, val maxTemp : Integer, val weather : String): Parcelable