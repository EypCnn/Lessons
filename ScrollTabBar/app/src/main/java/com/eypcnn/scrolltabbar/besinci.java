package com.eypcnn.scrolltabbar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class besinci extends Fragment {

    public besinci() {
        // Gerekli Boşluklar
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Düzen
        return inflater.inflate(R.layout.activity_besinci, container, false);
    }

}