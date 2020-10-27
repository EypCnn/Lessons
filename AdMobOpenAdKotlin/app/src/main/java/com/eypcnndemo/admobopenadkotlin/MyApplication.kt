package com.eypcnndemo.admobopenadkotlin

import android.app.Application
import com.google.android.gms.ads.MobileAds

/** The Application class that manages AppOpenManager.  */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(
            this
        ) { }
        appOpenManager = AppOpenManager(this)
    }

    companion object {
        private var appOpenManager: AppOpenManager? = null
    }
}