package com.example.todoschedule

import android.app.ListActivity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListAdapter
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

    fun onClick(view : View){
        var editText =  findViewById (R.id.editText) as EditText
        val toDoString : String = editText.text.toString();
        if (!toDoString.isEmpty()) {
            MainActivity.addStringToList(toDoString)
            var array = MainActivity.arrayOfItems
            arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, MainActivity.arrayOfItems)
            setListAdapter(arrayAdapter as ListAdapter?)
        }
         editText.setText("")
    }
}

