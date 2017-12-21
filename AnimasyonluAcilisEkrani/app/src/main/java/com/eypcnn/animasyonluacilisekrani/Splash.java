package com.eypcnn.animasyonluacilisekrani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    ImageView ey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ey = (ImageView) findViewById(R.id.acilis);
        Animation eyanimasyon = AnimationUtils.loadAnimation(this, R.anim.acilisanim);
        final Intent i = new Intent(this, MainActivity.class);
        Thread zamanlama = new Thread() {
            public void run() {
                try{
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        zamanlama.start();
    }
}
