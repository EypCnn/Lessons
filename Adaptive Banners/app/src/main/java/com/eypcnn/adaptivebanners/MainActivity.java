package com.eypcnn.adaptivebanners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.FrameLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    private static final String ADUNIT_ID = "ca-app-pub-3940256099942544/9214589741";
    FrameLayout adcontainer;
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adcontainer = findViewById(R.id.adviewContainer);
        adcontainer.post(new Runnable() {
            @Override
            public void run() {
                loadBanner();
            }
        });
    }

    private void loadBanner() {
        adView = new AdView(MainActivity.this);
        adView.setAdUnitId(ADUNIT_ID);
        adcontainer.removeAllViews();
        adcontainer.addView(adView);

        AdSize adSize = getAdSize();
        adView.setAdSize(adSize);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    private AdSize getAdSize() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);

        float density = displayMetrics.density;
        float adwidthpixels = adcontainer.getWidth();

        if (adwidthpixels == 0 ){
            adwidthpixels = displayMetrics.widthPixels;
        }

        int adWith = (int) (adwidthpixels / density);
        return AdSize.getCurrentOrientationBannerAdSizeWithWidth(MainActivity.this, adWith);
    }
}