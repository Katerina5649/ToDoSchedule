package com.example.todoschedule

import android.app.ListActivity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast

import java.lang.StringBuilder

class ActivityList : ListActivity() {

    private lateinit var arrayAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,MainActivity.arrayOfItems)
        setListAdapter(arrayAdapter)

    }
}

