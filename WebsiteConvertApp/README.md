# Night Mode


## AndroidManifest.xml
```xml
<uses-permission android:name="android.permission.INTERNET"></uses-permission>
```

## activity_main.xml

```xml
<WebView
        android:id="@+id/site"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </WebView>
```

## MainActivity.java

```xml
package com.eypcnn.siteyiuygulmayapma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView eypsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eypsite = (WebView) findViewById(R.id.site);
        WebSettings webSettings= eypsite.getSettings();
        webSettings.setJavaScriptEnabled(true);
        eypsite.loadUrl("http://google.com.tr");
        eypsite.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if (eypsite.canGoBack()){
            eypsite.goBack();
        }else {
            super.onBackPressed();
        }
    }
}

```