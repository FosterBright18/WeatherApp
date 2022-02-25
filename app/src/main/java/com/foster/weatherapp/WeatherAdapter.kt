package com.foster.weatherapp;

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class WeatherAdapter(var dataSet: List<WeatherInfo>) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewDate : TextView
        val textViewMaxTemp : TextView
        val textViewMinTemp : TextView
        val textViewWeather : TextView
        val layout : ConstraintLayout

        init{
            textViewDate = view.findViewById(R.id.textView_weatherItem_date)
            textViewMaxTemp = view.findViewById(R.id.textView_weatherItem_maxTemp)
            textViewMinTemp = view.findViewById(R.id.textView_weatherItem_minTemp)
            textViewWeather = view.findViewById(R.id.textView_weatherItem_weatherType)
            layout = view.findViewById(R.id.layout_weatherItem)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_weather, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getDay() : String {
        return "${Calendar.getInstance().get(Calendar.MONTH)}" +
                "/${Calendar.getInstance().get(Calendar.DAY_OF_MONTH)}" +
                "/${Calendar.getInstance().get(Calendar.YEAR)}"
    }



    override fun getItemCount(): Int {
        return dataSet.size
    }

    //override fun getDayWeather() : String{

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val date = dataSet[position]
        viewHolder.textViewDate.text = getDay()
        //viewHolder.textViewWeather.text = date.timeline[date.timeline.lastKey()].toString()
        /*viewHolder.layout.setOnClickListener {
            val context = viewHolder.layout.context
            val heroDetailIntent = Intent(context, WeatherDetailActivity::class.java).apply{
                putExtra(VaccinationDetailActivity.EXTRA_COUNTRY, country)
            }
            context.startActivity(heroDetailIntent) } */
    }

