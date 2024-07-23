package com.example.launcherapp

import android.annotation.SuppressLint


import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.CUPCAKE)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openCalculatorButton: Button = findViewById(R.id.openCalculatorButton)
        val openCountryInfoButton: Button = findViewById(R.id.openCountryInfoButton)

        openCalculatorButton.setOnClickListener {
            val packageName = "com.example.calculations" // Replace with your Calculator app package name
            val intent = packageManager.getLaunchIntentForPackage(packageName)
            if (intent != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Calculator app not found", Toast.LENGTH_SHORT).show()
                println("Intent for package $packageName is null")
            }
        }

        openCountryInfoButton.setOnClickListener {
            val packageName = "com.example.countryinfo" // Replace with your Country Info app package name
            val intent = packageManager.getLaunchIntentForPackage(packageName)
            if (intent != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Country Info app not found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
