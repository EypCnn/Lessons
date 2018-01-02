package com.eypcnn.diyalogpenceresireklam;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    NativeExpressAdView mAdView;
    VideoController mVideoController;
    private static String LOG_TAG ="EypCnn";

    Dialog main_dialog;
    private NumberProgressBar cub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater dialogLayout = LayoutInflater.from(MainActivity.this);
        View DialogView = dialogLayout.inflate(R.layout.cubuk, null);

        main_dialog = new Dialog(MainActivity.this,R.style.Uyari );
        main_dialog.setContentView(DialogView);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(main_dialog.getWindow().getAttributes());
        lp.width = (int) (getResources().getDisplayMetrics().widthPixels*0.90);
        lp.height = (int) (getResources().getDisplayMetrics().widthPixels*0.25);
        main_dialog.getWindow().setAttributes(lp);
        main_dialog.setCancelable(false);
        main_dialog.setCanceledOnTouchOutside(false);

        // AdMob Reklam

        mAdView = (NativeExpressAdView) DialogView.findViewById(R.id.adView);
        // Video seçeneklerini ayarlayın.
        mAdView.setVideoOptions(new VideoOptions.Builder()
                .setStartMuted(true)
                .build());

        // VideoController, bir reklamın videosu hakkında yaşam döngüsü olaylarını ve bilgilerini almak için kullanılabilir
        // Reklamın herhangi bir video olmasa bile, getVideoController tarafından her zaman iade edilecektir
        mVideoController = mAdView.getVideoController();
        mVideoController.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
            @Override
            public void onVideoEnd() {
                Log.d(LOG_TAG, "Video kayıttan yürütme tamamlandı.");
                super.onVideoEnd();
            }
        });

        // AdView için bir AdListener, böylece etkinliğin bir reklam tamamlandığında harekete geçmesi sağlar.
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                if (mVideoController.hasVideoContent()) {
                    Log.d(LOG_TAG, "Video varlığını içeren bir reklam aldı.");
                } else {
                    Log.d(LOG_TAG, "Video varlığı içermeyen bir reklam aldı.");
                }
            }
        });


        mAdView.loadAd(new AdRequest.Builder().build());

        cub = (NumberProgressBar) DialogView.findViewById(R.id.progres_bar);
        cub.setProgress(0);
        cub.setMax(100);


        webView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://forum.one-teams.com");
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                cub.setProgress(progress);
                if (progress == 100){
                    main_dialog.dismiss();
                } else {
                    main_dialog.show();
                }
            }
        });
    }
}
