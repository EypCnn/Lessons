package com.eypcnn.qsettingspanel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val internet = findViewById<Button>(R.id.internetButton)
        val volume = findViewById<Button>(R.id.volumeButton)
        val nfc = findViewById<Button>(R.id.nfcButton)

        internet.setOnClickListener(View.OnClickListener { startActivity(Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY)) })
        volume.setOnClickListener(View.OnClickListener { startActivity(Intent(Settings.Panel.ACTION_VOLUME)) })
        nfc.setOnClickListener(View.OnClickListener { startActivity(Intent(Settings.Panel.ACTION_NFC)) })

    }
}