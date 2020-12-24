package com.eypcnn.webviewdialog

import android.app.Dialog
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.webViewDialog)
        button.setOnClickListener {
            val dialog = Dialog(this@MainActivity)
            dialog.setContentView(R.layout.custom_dialog)

            val webView = dialog.findViewById<WebView>(R.id.webView)
            val webviewdata = "<html><body style='background:black;color:white;padding:3em;'> Custom WebView Dialog Kotlin </body></html>"
            webView.loadData(webviewdata, "text/html", "utf-8")

            val close = dialog.findViewById<Button>(R.id.diloagClose)
            close.setOnClickListener { dialog.dismiss() }

            dialog.show()
        }

    }
}