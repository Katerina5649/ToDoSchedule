package com.example.todoschedule

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.CalendarView

class MainActivity : AppCompatActivity() {

    var mapOfArrays : HashMap<String, Array<String>> = HashMap()

    companion object {
        @JvmStatic
        var arrayOfItems :Array<String> =  emptyArray()
    }

    fun convertDateToKey( year: Int, month : Int, dayOfMonth : Int): String {
        return java.lang.StringBuilder().
            append(year).
            append(".").
            append(month).
            append(".").
            append(dayOfMonth).
            toString()
    }
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarView = findViewById(R.id.calendarView) as CalendarView

        //Эта строка ответсвенна за клики на дату
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->

            val key : String = convertDateToKey(year, month, dayOfMonth)
            if (mapOfArrays.containsKey(key))
                arrayOfItems = mapOfArrays.get(key)!!
            else {
                arrayOfItems = arrayOf("Это","Мой","Массив")
                mapOfArrays.put(key, arrayOfItems)
            }

            arrayOfItems += key
            //переход на ActivityList
            val intent = Intent(this@MainActivity, ActivityList::class.java)
            startActivity(intent)
            //если это раскомититься, то из списка нельзя будет вернуться
            //finish()
        }
    }
}
