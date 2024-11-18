package com.example.project4 

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonExplicit: Button = findViewById(R.id.buttonExplicitIntent)
        val buttonImplicit: Button = findViewById(R.id.buttonImplicitIntent)

        // Explicit Intent - Navigate to SecondActivity
        buttonExplicit.setOnClickListener {
            val explicitIntent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(explicitIntent)
        }

        // Implicit Intent - Open a website
        buttonImplicit.setOnClickListener {
            val implicitIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(implicitIntent)
        }
    }
}
