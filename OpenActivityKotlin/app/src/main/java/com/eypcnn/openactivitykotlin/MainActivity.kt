package com.eypcnn.openactivitykotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next = findViewById<View>(R.id.nextButton) as Button
        next.setOnClickListener { startActivity(Intent(this@MainActivity, MainActivity2::class.java)) }

    }
}