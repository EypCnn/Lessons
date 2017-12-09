# Night Mode

## build.gradle
```xml
implementation 'com.android.support:cardview-v7:26.1.0'

```

## attrs.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <declare-styleable name="eyp">
        <attr name="backgroundcolor" format="color"/>
        <attr name="cardbackground" format="color"/>
        <attr name="textcolor" format="color" />
        <attr name="tintcolor" format="color" />
        <attr name="buttoncolor" format="color"/>
    </declare-styleable>
</resources>

```

## styles.xml
```xml
<resources>

    <!-- Base application theme.
    Light/Day Mode-->
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">#2192F3</item>
        <item name="colorPrimaryDark">#1976D2</item>
        <item name="colorAccent">@color/colorAccent</item>
        <item name="backgroundcolor">#fcfcfc</item>
        <item name="cardbackground">#ffffff</item>
        <item name="textcolor">#808080</item>
        <item name="tintcolor">#000000</item>
        <item name="buttoncolor">#2192F3</item>
    </style>

    <!-- Base application theme.
    DArk Mode-->
    <style name="darktheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">#212121</item>
        <item name="colorPrimaryDark">#000000</item>
        <item name="colorAccent">@color/colorAccent</item>
        <item name="backgroundcolor">#303030</item>
        <item name="cardbackground">#424242</item>
        <item name="textcolor">#ffffff</item>
        <item name="tintcolor">#ffffff</item>
        <item name="buttoncolor">#2192F3</item>
    </style>

</resources>


```


## activity_ayarlar.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="24dp"
    android:background="?attr/backgroundcolor"
    android:orientation="vertical"
    tools:context="com.eypcnn.gecemodu.Ayarlar">
    <android.support.v7.widget.CardView
        app:cardBackgroundColor="?attr/backgroundcolor"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <LinearLayout
            android:orientation="vertical"
            android:padding="10dp"
            android:layout_width="match_parent"
            android:layout_height="match_parent">
            <TextView
                android:textStyle="bold"
                android:textColor="?attr/textcolor"
                android:text="Card Title"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content" />
            <TextView
                android:layout_marginTop="8dp"
                android:textColor="?attr/textcolor"
                android:text="Test App"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content" />
        </LinearLayout>
    </android.support.v7.widget.CardView>

    <android.support.v7.widget.CardView
        app:cardBackgroundColor="?attr/backgroundcolor"
        android:layout_marginTop="15dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <LinearLayout
            android:layout_marginTop="10dp"
            android:orientation="vertical"
            android:layout_width="match_parent"
            android:layout_height="match_parent">
            <TextView
                android:textStyle="bold"
                android:textColor="?attr/textcolor"
                android:text="Some Options"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content" />
            <RadioButton
                android:textColor="?attr/textcolor"
                android:layout_marginTop="5dp"
                android:text="Radio Button"
                android:buttonTint="?attr/tintcolor"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content" />
            <CheckBox
                android:textColor="?attr/textcolor"
                android:buttonTint="?attr/tintcolor"
                android:text="CheckBox"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content" />
            <Button
                android:backgroundTint="?attr/buttoncolor"
                android:textColor="#fff"
                android:text="Button"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content" />
        </LinearLayout>
    </android.support.v7.widget.CardView>

    <android.support.v7.widget.CardView
        app:cardBackgroundColor="?attr/backgroundcolor"
        android:layout_marginTop="15dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <LinearLayout
            android:orientation="vertical"
            android:padding="10dp"
            android:layout_width="match_parent"
            android:layout_height="match_parent">
            <TextView
                android:textStyle="bold"
                android:textColor="?attr/textcolor"
                android:text="Enable Dark Mode"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content" />
            <Switch
                android:id="@+id/enabledark"
                android:layout_marginTop="8dp"
                android:textColor="?attr/textcolor"
                android:text="Night Mod"
                android:layout_width="match_parent"
                android:layout_height="wrap_content" />
        </LinearLayout>
    </android.support.v7.widget.CardView>
</LinearLayout>


```

## Ayarlar.java

```xml
package com.eypcnn.gecemodu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Ayarlar extends AppCompatActivity {

    private Switch eyp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darktheme);
        }
        else setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayarlar);
        eyp=(Switch)findViewById(R.id.enabledark);
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            eyp.setChecked(true);
        }
        eyp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartApp();
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartApp();
                }
            }
        });
    }
    public void restartApp () {
        Intent i = new Intent(getApplicationContext(),Ayarlar.class);
        startActivity(i);
        finish();
    }
}

```