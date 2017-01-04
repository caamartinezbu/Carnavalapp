package com.controlapp.beto.riosucio;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by Beto on 08/11/2016.
 */
public class PanelFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.panel_fragment, container, false);


        ImageButton btncuadrillas = (ImageButton)view.findViewById(R.id.btn_cuadrillas);
        btncuadrillas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cuadrillas = new Intent(getActivity(), Cuadrillas.class);
                startActivity(cuadrillas);
            }
        });

        ImageButton btnprogramacion = (ImageButton)view.findViewById(R.id.btn_programacion);
        btnprogramacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent programacion = new Intent(getActivity(), Programacion.class);
                startActivity(programacion);
            }
        });

        ImageButton btn_noticias = (ImageButton)view.findViewById(R.id.btn_noticias);
        btn_noticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(view, "No estoy activo", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

               /* Intent noticias = new Intent(getActivity(), Noticias.class);
                startActivity(noticias);*/
            }
        });




       /* ((NavigationDrawer_Home) getActivity()).getSupportActionBar().setTitle("Fragment Inbox");

        Button buttonChangeText = (Button) view.findViewById(R.id.buttonFragmentHimno);

        final TextView textViewHimnoFragment = (TextView) view.findViewById(R.id.textViewHimnoFragment);

        buttonChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewHimnoFragment.setText("Esta es el Himno");
                textViewHimnoFragment.setTextColor(getResources().getColor(R.color.colorPrimary));

            }
        });*/

        return view;
    }
}
