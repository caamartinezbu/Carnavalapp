package com.controlapp.beto.riosucio;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Beto on 08/11/2016.
 */
public class PanelFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.panel_fragment, container, false);

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
