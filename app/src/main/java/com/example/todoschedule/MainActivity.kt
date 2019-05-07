package com.example.todoschedule

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener




class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarView = findViewById(R.id.calendarView) as CalendarView
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val selectedDate = StringBuilder().append(month + 1)
                .append("-").append(dayOfMonth).append("-").append(year)
                .append(" ").toString()
            Toast.makeText(applicationContext, selectedDate, Toast.LENGTH_LONG).show()
        }
    }
}
