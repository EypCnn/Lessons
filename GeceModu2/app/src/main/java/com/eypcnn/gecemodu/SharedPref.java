package com.eypcnn.gecemodu;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by EypCnn on 26.12.2017.
 */

public class SharedPref {

    SharedPreferences mySharedPref ;
    public SharedPref(Context context) {
        mySharedPref = context.getSharedPreferences("filename",Context.MODE_PRIVATE);
    }
    // Gece Modu Durumunu Kaydetmete Yarar
    public void setNightModeState(Boolean state) {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("Gece Modu",state);
        editor.commit();
    }
    // Kayıtlı Gece Modu Durumunu Yükle
    public Boolean loadNightModeState (){
        Boolean state = mySharedPref.getBoolean("Gece Modu",false);
        return  state;
    }
}
