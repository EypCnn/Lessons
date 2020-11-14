package com.eypcnn.qsettingspanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button internet, volume, nfc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        internet = findViewById(R.id.internetButton);
        volume = findViewById(R.id.volumeButton);
        nfc = findViewById(R.id.nfcButton);

        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY));
            }
        });

        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Settings.Panel.ACTION_VOLUME));
            }
        });

        nfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Settings.Panel.ACTION_NFC));
            }
        });
    }
}