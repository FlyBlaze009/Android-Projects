package com.example.project3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Reference to UI elements
        val editTextName: EditText = findViewById(R.id.editTextName)
        val buttonSubmit: Button = findViewById(R.id.buttonSubmit)

        // Set an OnClickListener for the button
        buttonSubmit.setOnClickListener {
            val name = editTextName.text.toString().trim()
            if (name.isNotEmpty()) {
                // Show a Toast message
                Toast.makeText(this, "Hello, $name", Toast.LENGTH_SHORT).show()
            } else {
                // If name is empty, prompt the user
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
