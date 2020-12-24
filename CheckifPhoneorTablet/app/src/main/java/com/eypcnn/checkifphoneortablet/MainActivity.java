package com.eypcnn.checkifphoneortablet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.checkphonetablet);
        textView.setText(getDeviceInfo(getApplicationContext(), Device.DEVICE_TYPE));
    }

    public enum Device {
        DEVICE_TYPE,
    }

    public static String getDeviceInfo (Context context, Device device) {
        try {
            switch (device) {
                case DEVICE_TYPE:
                    if (isTablet(context)) {
                        if (getDevice5Inch(context)) {
                            return "Tablet";
                        } else {
                            return "Mobile";
                        }
                    } else {
                        return "Mobile";
                    }
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    private static boolean getDevice5Inch(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float yinch = displayMetrics.heightPixels / displayMetrics.ydpi;
            float xinch = displayMetrics.widthPixels / displayMetrics.xdpi;

            double diagonalinch = Math.sqrt(xinch * xinch + yinch * yinch);
            if (diagonalinch >= 7) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }


}