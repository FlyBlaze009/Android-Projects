package com.example.project7

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    // Sample data
    private val fruits = listOf("Apple", "Banana", "Orange", "Mango", "Grapes", "Pineapple", "Strawberry")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.myListView)

        // Creating an ArrayAdapter
        val adapter = ArrayAdapter(this, R.layout.list_item, R.id.textViewItem, fruits)

        // Setting the adapter to the ListView
        listView.adapter = adapter
    }
}
