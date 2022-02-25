package com.foster.weatherapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class WeatherInfo(val time : Integer, val temp : Integer,val wind : SortedMap<String, Long>, val precA : Integer, val weather : String): Parcelable