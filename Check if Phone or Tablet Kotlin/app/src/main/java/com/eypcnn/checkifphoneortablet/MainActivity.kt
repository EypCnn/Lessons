package com.eypcnn.checkifphoneortablet

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.checkphonetablet)
        textView.text = getDeviceInfo(applicationContext, Device.DEVICE_TYPE)

    }

    enum class Device {
        DEVICE_TYPE
    }

    companion object{
        fun getDeviceInfo (context: Context, device: Device?): String {
            try {
                when (device) {
                    Device.DEVICE_TYPE -> return if (isTablet(context)) {
                        if (getDevice5inch(context)) {
                            "Tablet"
                        } else {
                            "Mobile"
                        }
                    } else {
                        "Mobile"
                    } else -> {

                }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }

        private fun getDevice5inch(context: Context): Boolean {
            return try {
                val displayMetrics = context.resources.displayMetrics
                val yinch = displayMetrics.heightPixels / displayMetrics.ydpi
                val xinch = displayMetrics.widthPixels / displayMetrics.xdpi
                val diagonalinch = Math.sqrt(xinch * xinch + yinch * yinch.toDouble())

                if (diagonalinch >= 7) {
                    true
                } else {
                    false
                }

            } catch (e: Exception) {
                false
            }

        }

        private fun isTablet(context: Context): Boolean {
            return context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
        }
    }
}