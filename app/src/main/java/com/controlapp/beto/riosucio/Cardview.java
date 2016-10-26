package com.controlapp.beto.riosucio;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
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

        inicializarDatos();
        inicializaAdaptador();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Carnaval De Riosucio", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void inicializarDatos(){
        Tarjetas = new ArrayList<>();
        Tarjetas.add(new Tarjeta(R.drawable.desfile, "Desfile De Cuadrillas"));
        Tarjetas.add(new Tarjeta(R.drawable.comparsa, "El diablo"));
        Tarjetas.add(new Tarjeta(R.drawable.afiche, "Afiche de Carnaval 2017"));
        Tarjetas.add(new Tarjeta(R.drawable.riosucio, "Panoramica Riosicio"));


    }


    public TarjetaAdapador adaptador;
    private void inicializaAdaptador(){
        adaptador = new TarjetaAdapador(Tarjetas);
        ListaTarjetas.setAdapter(adaptador);
    }
}
