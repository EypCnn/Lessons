package com.eypcnn.openactivitykotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val pre = findViewById<View>(R.id.preButton) as Button
        pre.setOnClickListener { startActivity(Intent(this@MainActivity2, MainActivity::class.java)) }
    }
}