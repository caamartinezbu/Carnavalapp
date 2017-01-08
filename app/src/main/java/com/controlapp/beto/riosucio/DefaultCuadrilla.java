package com.controlapp.beto.riosucio;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by unalman on 3/01/2017.
 */

public class DefaultCuadrilla extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout = null;

    // CONNECTION_TIMEOUT and READ_TIMEOUT are in milliseconds
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;
    private String eventId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defaultcuadrilla);

        Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initCollapsingToolbar();

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(getResources().getString(R.string.title_activity_cuadrillas));


        toolbarTextAppernce();


        TypedValue typedValueColorPrimaryDark = new TypedValue();
        DefaultCuadrilla.this.getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValueColorPrimaryDark, true);
        final int colorPrimaryDark = typedValueColorPrimaryDark.data;
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(colorPrimaryDark);
        }

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            eventId = extras.get("event_id").toString();
            new AsyncLogin().execute();

        }

    }

    private void toolbarTextAppernce() {
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
    }
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.title_activity_cuadrillas));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }


    private class AsyncLogin extends AsyncTask<String, String, String> {
        ProgressDialog pdLoading = new ProgressDialog(DefaultCuadrilla.this);
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //this method will be running on UI thread
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();

        }


        private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException
        {
            StringBuilder result = new StringBuilder();
            boolean first = true;

            for (NameValuePair pair : params)
            {
                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
            }

            return result.toString();
        }


        @Override
        protected String doInBackground(String... params) {
            try {

                // Enter URL address where your json file resides
                // Even you can make call to php file which returns json data
                url = new URL(new Constants().getEventsQueryUrl());

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return e.toString();
            }
            try {

                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);

                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                List<NameValuePair> parameters = new ArrayList<NameValuePair>();
                parameters.add(new BasicNameValuePair("token", "n8Qhi3CImB8nb9ZXIZ9gcPb4KMlgUd5g"));
                parameters.add(new BasicNameValuePair("action", "SELECT_GANG"));
                parameters.add(new BasicNameValuePair("gang_id", eventId));
                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getQuery(parameters));
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return e1.toString();
            }

            try {

                int response_code = conn.getResponseCode();

                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {

                        result.append(line);
                    }

                    // Pass data to onPostExecute method
                    return (result.toString());

                } else {

                    return ("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            } finally {
                conn.disconnect();
            }


        }

        @Override
        protected void onPostExecute(String result) {

            //this method will be running on UI thread
            pdLoading.dismiss();
            List<Event> data=new ArrayList<>();

            pdLoading.dismiss();
            try {

                JSONArray jArray = new JSONArray(result);

                // Extract data from json and store into ArrayList as class objects
                Cuadrilla cuadrillaData = new Cuadrilla();
                for(int i=0;i<jArray.length();i++){
                    JSONObject json_data = jArray.getJSONObject(i);

                    cuadrillaData.setId(json_data.getString("id"));
                    cuadrillaData.setNombre(json_data.getString("nombre"));
                    cuadrillaData.setNombreCapitan(json_data.getString("nombre_capitan"));
                    cuadrillaData.setPresentacion(json_data.getString("presentacion"));
                    cuadrillaData.setCiudad(json_data.getString("ciudad"));
                    cuadrillaData.setLinkImagen(json_data.getString("link_imagen"));
                    cuadrillaData.setLetra_uno(json_data.getString("letra_uno"));
                    cuadrillaData.setLetra_dos(json_data.getString("letra_dos"));
                    cuadrillaData.setLetra_tres(json_data.getString("letra_tres"));
                    cuadrillaData.setTitulo_uno(json_data.getString("titulo_uno"));
                    cuadrillaData.setTitulo_dos(json_data.getString("titulo_dos"));
                    cuadrillaData.setTitulo_tres(json_data.getString("titulo_tres"));

                }

                Glide.with(DefaultCuadrilla.this).load("http://controlapp.com.co/carnaval/images/cuadrillas/" + cuadrillaData.getLinkImagen()).into((ImageView) findViewById(R.id.backdrop));
                TextView gangName = (TextView) findViewById(R.id.gangName);
                gangName.setText(cuadrillaData.getNombre());
                TextView gangCaptain = (TextView) findViewById(R.id.gangCaptain);
                gangCaptain.setText(cuadrillaData.getNombreCapitan());
                TextView gangCity = (TextView) findViewById(R.id.gangCity);
                gangCity.setText(cuadrillaData.getCiudad());
                TextView prententation = (TextView) findViewById(R.id.prententation);
                prententation.setText(cuadrillaData.getPresentacion());
                TextView titulo1 = (TextView) findViewById(R.id.titulo1);
                titulo1.setText(cuadrillaData.getTitulo_uno());
                TextView titulo2 = (TextView) findViewById(R.id.titulo2);
                titulo2.setText(cuadrillaData.getTitulo_dos());
                TextView titulo3 = (TextView) findViewById(R.id.titulo3);
                titulo3.setText(cuadrillaData.getTitulo_tres());
                TextView letra1 = (TextView) findViewById(R.id.letra1);
                letra1.setText(cuadrillaData.getLetra_uno());
                TextView letra2 = (TextView) findViewById(R.id.letra2);
                letra2.setText(cuadrillaData.getLetra_dos());
                TextView letra3 = (TextView) findViewById(R.id.letra3);
                letra3.setText(cuadrillaData.getLetra_tres());



            } catch (JSONException e) {
                Toast.makeText(DefaultCuadrilla.this, "Por favor  conecte su Wifi o plan de datos", Toast.LENGTH_LONG).show();
            }

        }

    }
}


