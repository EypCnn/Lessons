package com.eypcnn.darkwebview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebView
import android.os.Bundle
import android.view.View
import com.eypcnn.darkwebview.R
import com.eypcnn.darkwebview.MainActivity.WebViewClientt
import androidx.webkit.WebViewFeature
import androidx.webkit.WebSettingsCompat
import android.webkit.WebViewClient
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var webView: WebView? = null
    var light: Button? = null
    var dark: Button? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        light = findViewById(R.id.lightweb)
        dark = findViewById(R.id.darkweb)

        webView.getSettings().javaScriptEnabled = true
        webView.loadUrl("https://www.google.com")
        webView.setWebViewClient(WebViewClientt())

        light.setOnClickListener(View.OnClickListener {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                WebSettingsCompat.setForceDark(webView.getSettings(), WebSettingsCompat.FORCE_DARK_OFF)
            }
        })

        dark.setOnClickListener(View.OnClickListener {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                WebSettingsCompat.setForceDark(webView.getSettings(), WebSettingsCompat.FORCE_DARK_ON)
            }
        })
    }

    private inner class WebViewClientt : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }

    override fun onBackPressed() {
        if (webView!!.canGoBack()) {
            webView!!.goBack()
        } else {
            super.onBackPressed()
        }
    }
}