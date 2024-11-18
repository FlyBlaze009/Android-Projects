package com.example.project8

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showDialogButton: Button = findViewById(R.id.showDialogButton)

        // Set a click listener to show the alert dialog
        showDialogButton.setOnClickListener {
            showAlertDialog()
        }
    }

    // Function to show alert dialog
    private fun showAlertDialog() {
        // Initialize an AlertDialog builder
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("Are you sure you want to proceed?")

        // Add "OK" button with a click listener
        builder.setPositiveButton("OK") { dialog, _ ->
            // Action for "OK" button
            dialog.dismiss()
        }

        // Add "Cancel" button with a click listener
        builder.setNegativeButton("Cancel") { dialog, _ ->
            // Action for "Cancel" button
            dialog.dismiss()
        }

        // Create and show the alert dialog
        val alertDialog = builder.create()
        alertDialog.show()
    }
}
