package com.controlapp.beto.riosucio;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.SupportMapFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapFragment_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapFragment_1 extends SupportMapFragment {

    public MapFragment_1() {
    }

    public static MapFragment_1 newInstance() {
        return new MapFragment_1();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);

        return root;
    }


}
