package com.controlapp.beto.riosucio;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Cardview extends AppCompatActivity {


    private RecyclerView ListaTarjetas;
    private List<Tarjeta> Tarjetas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListaTarjetas = (RecyclerView) findViewById(R.id.Rvtarjetas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ListaTarjetas.setLayoutManager(llm);
/*
        inicializarDatos();
        inicializaAdaptador();*/



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Carnaval De Riosucio", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
/*
    public void inicializarDatos(){
        Tarjetas = new ArrayList<>();
        Tarjetas.add(new Tarjeta(R.drawable.desfile, "Desfile De Cuadrillas"));
        Tarjetas.add(new Tarjeta(R.drawable.comparsa, "El diablo"));
        Tarjetas.add(new Tarjeta(R.drawable.afiche, "Afiche de Carnaval 2017"));
        Tarjetas.add(new Tarjeta(R.drawable.riosucio, "Panoramica Riosicio"));


    }*/

/*
    public TarjetaAdapador adaptador;
    private void inicializaAdaptador(){
        adaptador = new TarjetaAdapador(Tarjetas);
        ListaTarjetas.setAdapter(adaptador);
    }*/

    /**
     * Created by JuanSe on 6/11/16.
     */
    public static class ServerConnection extends AsyncTask {


        public ServerConnection(){

        }
        @Override
        protected Object doInBackground(Object[] params) {


            try {
                this.downloadUrl("https://carnavaldiablo.000webhostapp.com/validate_date.php");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;

        }


        public String downloadUrl(String url) throws IOException {
            HttpClient httpclient = new DefaultHttpClient();
            HttpRequestBase httpRequest = null;
            HttpResponse httpResponse = null;
            InputStream inputStream = null;
            String response = "";
            StringBuffer buffer = new StringBuffer();
            httpRequest = new HttpGet(url);
            httpResponse = httpclient.execute(httpRequest);
            inputStream = httpResponse.getEntity().getContent();
            int contentLength = (int) httpResponse.getEntity().getContentLength();
            if (contentLength < 0)  {
                // Log.e(TAG, "The HTTP response is too long.");
            }
            byte[] data = new byte[256];
            int len = 0;
            while (-1 != (len = inputStream.read(data)) ) {
                buffer.append(new String(data, 0, len));
            }
            inputStream.close();
            response = buffer.toString();
            return response;
        }
    }
}
