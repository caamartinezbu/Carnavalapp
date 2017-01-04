package com.controlapp.beto.riosucio.Fragments;

import android.Manifest;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.controlapp.beto.riosucio.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

/**
 * Created by unalman on 28/12/2016.
 */

public class DieciochoFragment extends Fragment implements OnMapReadyCallback{

    private static View view;
    private final static int MY_PERMISSION_FINE_LOCATION = 101;

    GoogleMap googleMap;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.fragment_dieciocho, container,false);
        } catch (InflateException e) {
        /* map is already there, just return view as it is */
        }
        return view;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MapFragment fragment ;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fragment = (MapFragment)getChildFragmentManager()
                    .findFragmentById(R.id.map18);
        }else {
            fragment = (MapFragment)getActivity().getFragmentManager()
                    .findFragmentById(R.id.map18);
        }
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ) {
            googleMap.setMyLocationEnabled(true);

        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},MY_PERMISSION_FINE_LOCATION);
            }
        }

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(5.420926, -75.702909), 17));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(5.420135, -75.702238))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_templo))
                .title("Iglesia Nuestra Señora De La Candelaria"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(5.421297, -75.704330))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_templo))
                .title("Iglesia San Sebastian"));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(5.421031, -75.701881))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_bombero))
                .title("Bomberos"));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(5.421726, -75.703453))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_alimento))
                .title("Vienesa Café"));


        //inicio y fin
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(5.419066, -75.701997))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_inicio))
                .title("Inicio Desfile"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(5.420274, -75.702753))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_final))
                .title("Fin Desfile"));
        //Dibujo de recorrido
        PolylineOptions lineas = new PolylineOptions()
                .add(new LatLng(5.419066, -75.701997))
                .add(new LatLng(5.420364, -75.701205))
                .add(new LatLng(5.421723, -75.703497))
                .add(new LatLng(5.422065, -75.704169))
                .add(new LatLng(5.421403, -75.704349))
                .add(new LatLng(5.421342, -75.704250))
                .add(new LatLng(5.420706, -75.704400))
                .add(new LatLng(5.420577, -75.703842))
                .add(new LatLng(5.420859, -75.703751))
                .add(new LatLng(5.420274, -75.702753));
                lineas.width(5);
                lineas.color(Color.RED);
                googleMap.addPolyline(lineas);

        // dibujo de el segundo parque
        LatLng p1 = new LatLng(5.420771, -75.704328);
        LatLng p2 = new LatLng(5.421289, -75.704210);
        LatLng p3 = new LatLng(5.421169, -75.703703);
        LatLng p4 = new LatLng(5.420643, -75.703885);
        Polygon segundo_parque = googleMap.addPolygon(new PolygonOptions()
                .add(p1, p2, p3, p4, p1)
                .strokeColor(Color.parseColor("#CBE6A3"))
                .fillColor(Color.parseColor("#CBE6A3")));

        // dibujo de tatima partque principal
        LatLng t1 = new LatLng(5.420959, -75.702289);
        LatLng t2 = new LatLng(5.420884, -75.702324);
        LatLng t3 = new LatLng(5.420825, -75.702214);
        LatLng t4 = new LatLng(5.420893, -75.702166);
        Polygon tarima_uno = googleMap.addPolygon(new PolygonOptions()
                .add(t1,t2,t3,t4)
                .strokeColor(Color.parseColor("#F40503"))
                .zIndex(15)
                .strokeWidth(4)
                .fillColor(Color.parseColor("#973506")));
        // dibujo de tatima partque principal
        LatLng t21 = new LatLng(5.421079, -75.704257);
        LatLng t22 = new LatLng(5.421058, -75.704147);
        LatLng t23 = new LatLng(5.420900, -75.704177);
        LatLng t24 = new LatLng(5.420929, -75.704300);
        Polygon tarima_dos = googleMap.addPolygon(new PolygonOptions()
                .add(t21,t22,t23,t24)
                .strokeColor(Color.parseColor("#F40503"))
                .zIndex(15)
                .strokeWidth(4)
                .fillColor(Color.parseColor("#973506")));


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSION_FINE_LOCATION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        googleMap.setMyLocationEnabled(true);
                    }

                } else {
                    Toast.makeText(getActivity(), "Esta aplicación requiere que se concedan permisos de ubicación", Toast.LENGTH_SHORT).show();

                }
                break;
        }
    }

}
