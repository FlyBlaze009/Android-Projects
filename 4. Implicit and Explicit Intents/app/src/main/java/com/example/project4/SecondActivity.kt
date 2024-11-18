package com.example.project4

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Correctly reference the TextView by its ID
        val textViewMessage: TextView = findViewById(R.id.textViewMessage)
        textViewMessage.text = "Welcome to Second Activity!"
    }
}
