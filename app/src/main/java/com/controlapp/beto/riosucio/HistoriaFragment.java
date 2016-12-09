package com.controlapp.beto.riosucio;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Beto on 20/10/2016.
 */
public class HistoriaFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.historia_fragment, container, false);

       /* ((NavigationDrawer_Home) getActivity()).getSupportActionBar().setTitle("Fragment Inbox");

        Button buttonChangeText = (Button) view.findViewById(R.id.buttonFragmentInbox);

        final TextView textViewInboxFragment = (TextView) view.findViewById(R.id.textViewInboxFragment);

        buttonChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewInboxFragment.setText("Esta es la Historia");
                textViewInboxFragment.setTextColor(getResources().getColor(R.color.colorPrimary));

            }
        });
*/
        return view;
    }


}
