package com.controlapp.beto.riosucio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawer_Home extends AppCompatActivity /*implements NavigationView.OnNavigationItemSelectedListener */ {

    DrawerLayout drawerLayout;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
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

/*
 FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab3);
                    fab.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View view) {

                    Intent about = new Intent(NavigationDrawer_Home.this, .class);
                    startActivity(about);

               /* Snackbar.make(view, "Carnaval De Riosucio", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();*/
              /*  }
                });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
      /*  navigationView.setNavigationItemSelectedListener(this);*/

        setupNavigationDrawerContent(navigationView);
        //First start (Inbox Fragment)
        setFragment(0);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();


        FloatingActionButton myFab = (FloatingActionButton) this.findViewById(R.id.fab3);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(NavigationDrawer_Home.this, AboutActivity.class);
                startActivity(intent);
            }
        });

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


    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_navigation_drawer_panel:
                                menuItem.setChecked(true);
                                setFragment(0);
                                DrawerLayout drawer4 = (DrawerLayout) findViewById(R.id.drawer_layout);
                                drawer4.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_himno:
                                menuItem.setChecked(true);
                                setFragment(1);
                                DrawerLayout drawer3 = (DrawerLayout) findViewById(R.id.drawer_layout);
                                drawer3.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_historia:
                                menuItem.setChecked(true);
                                setFragment(2);
                                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                                drawer.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_mapas:
                                menuItem.setChecked(true);
                                //Toast.makeText(NavigationDrawer_Home.this, "Mapas" + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                DrawerLayout drawer2 = (DrawerLayout) findViewById(R.id.drawer_layout);
                                drawer2.closeDrawer(GravityCompat.START);
                                Intent intent2 = new Intent(NavigationDrawer_Home.this, MainActivity.class);
                                startActivity(intent2);
                                return true;
                               case R.id.item_navigation_drawer_tutorial:
                                menuItem.setChecked(true);
                                DrawerLayout drawer5 = (DrawerLayout) findViewById(R.id.drawer_layout);
                                drawer5.closeDrawer(GravityCompat.START);
                                Intent intent5 = new Intent(NavigationDrawer_Home.this, WelcomeActivity.class);
                                startActivity(intent5);
                                finish();
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
                PanelFragment panelFragment = new PanelFragment();
                fragmentTransaction.replace(R.id.fragment, panelFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                HimnoFragment himnoFragment = new HimnoFragment();
                fragmentTransaction.replace(R.id.fragment, himnoFragment);
                fragmentTransaction.commit();
                break;
            case 2:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                HistoriaFragment historiaFragment = new HistoriaFragment();
                fragmentTransaction.replace(R.id.fragment, historiaFragment);
                fragmentTransaction.commit();
                break;
        }
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("NavigationDrawer_Home Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
