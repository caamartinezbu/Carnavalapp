package com.controlapp.beto.riosucio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawer_Home extends AppCompatActivity /*implements NavigationView.OnNavigationItemSelectedListener */{

    DrawerLayout drawerLayout;
/*
    private RecyclerView ListaTarjetas;
    private List<Tarjeta> Tarjetas;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer__home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
        ListaTarjetas = (RecyclerView) findViewById(R.id.Rvtarjetas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ListaTarjetas.setLayoutManager(llm);*/
/*
        inicializarDatos();
        inicializaAdaptador();*/

/**
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Carnaval De Riosucio", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });**/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
      /*  navigationView.setNavigationItemSelectedListener(this);*/

        setupNavigationDrawerContent(navigationView);

    }

/*
        public void inicializarDatos(){
        Tarjetas = new ArrayList<>();
        Tarjetas.add(new Tarjeta(R.drawable.comparsa, "El diablo"));
        Tarjetas.add(new Tarjeta(R.drawable.afiche, "Afiche de Carnaval 2017"));
        Tarjetas.add(new Tarjeta(R.drawable.riosucio, "Panoramica Riosicio"));
            Tarjetas.add(new Tarjeta(R.drawable.desfile, "Desfile De Cuadrillas"));

        }


public TarjetaAdapador adaptador;
private void inicializaAdaptador(){
        adaptador = new TarjetaAdapador(Tarjetas);
        ListaTarjetas.setAdapter(adaptador);
        }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer__home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
   @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
       /* int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/


    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_navigation_drawer_himno:
                                menuItem.setChecked(true);
                                setFragment(0);
                                DrawerLayout drawer3 = (DrawerLayout) findViewById(R.id.drawer_layout);
                                drawer3.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_historia:
                                menuItem.setChecked(true);
                                setFragment(1);
                                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                                drawer.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_mapas:
                                menuItem.setChecked(true);
                                Toast.makeText(NavigationDrawer_Home.this, "Mapas" + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                DrawerLayout drawer2 = (DrawerLayout) findViewById(R.id.drawer_layout);
                                drawer2.closeDrawer(GravityCompat.START);
                                Intent intent2 = new Intent(NavigationDrawer_Home.this, Mapas.class);
                                startActivity(intent2);
                                return true;
                            case R.id.item_navigation_drawer_cuadrillas:
                                menuItem.setChecked(true);
                                //Toast.makeText(NavigationDrawer_Home.this, "cuadrillas " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                DrawerLayout drawer1 = (DrawerLayout) findViewById(R.id.drawer_layout);
                                drawer1.closeDrawer(GravityCompat.START);
                                Intent intent = new Intent(NavigationDrawer_Home.this, Cuadrillas.class);
                                startActivity(intent);
                                return true;

                        }

                        return true;
                    }
                });
    }


    public void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 0:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                HimnoFragment himnoFragment = new HimnoFragment();
                fragmentTransaction.replace(R.id.fragment,himnoFragment );
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                HistoriaFragment historiaFragment = new HistoriaFragment();
                fragmentTransaction.replace(R.id.fragment, historiaFragment);
                fragmentTransaction.commit();
                break;
        }
    }


}
