package com.controlapp.beto.riosucio;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.controlapp.beto.riosucio.Fragments.CuartoFragment;
import com.controlapp.beto.riosucio.Fragments.DecimoFragment;
import com.controlapp.beto.riosucio.Fragments.DecimoPrimeroFragment;
import com.controlapp.beto.riosucio.Fragments.DieciochoFragment;
import com.controlapp.beto.riosucio.Fragments.DieciseisFragment;
import com.controlapp.beto.riosucio.Fragments.DiecisieteFragment;
import com.controlapp.beto.riosucio.Fragments.DoceFragment;
import com.controlapp.beto.riosucio.Fragments.GmapFragment;
import com.controlapp.beto.riosucio.Fragments.ImportFragment;
import com.controlapp.beto.riosucio.Fragments.NovenoFragment;
import com.controlapp.beto.riosucio.Fragments.OctavoFragment;
import com.controlapp.beto.riosucio.Fragments.QuintoFragment;
import com.controlapp.beto.riosucio.Fragments.SextoFragment;
import com.controlapp.beto.riosucio.Fragments.TercerFragment;
import com.controlapp.beto.riosucio.Fragments.catorceFragment;
import com.controlapp.beto.riosucio.Fragments.quinceFragment;
import com.controlapp.beto.riosucio.Fragments.septimoFragment;
import com.controlapp.beto.riosucio.Fragments.treceFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImportFragment importFragment = new ImportFragment();
    CuartoFragment cuartoFragment = new CuartoFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, new ImportFragment()).commit();

    }

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
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fm = getFragmentManager();

        int id = item.getItemId();

        if (id == R.id.nav_1) {
            fm.beginTransaction().replace(R.id.content_frame, importFragment).commit();
        } else if (id == R.id.nav_2) {
            fm.beginTransaction().replace(R.id.content_frame, new GmapFragment()).commit();
        } else if (id == R.id.nav_3) {
            fm.beginTransaction().replace(R.id.content_frame, new TercerFragment()).commit();

        } else if (id == R.id.nav_4) {
            fm.beginTransaction().replace(R.id.content_frame, cuartoFragment).commit();

        }else if (id == R.id.nav_5) {
            fm.beginTransaction().replace(R.id.content_frame, new QuintoFragment()).commit();

        }else if (id == R.id.nav_6) {
            fm.beginTransaction().replace(R.id.content_frame, new SextoFragment()).commit();

        }else if (id == R.id.nav_7) {
            fm.beginTransaction().replace(R.id.content_frame, new septimoFragment()).commit();

        }else if (id == R.id.nav_8) {
            fm.beginTransaction().replace(R.id.content_frame, new OctavoFragment()).commit();

        }else if (id == R.id.nav_9) {
            fm.beginTransaction().replace(R.id.content_frame, new NovenoFragment()).commit();

        }else if (id == R.id.nav_10) {
            fm.beginTransaction().replace(R.id.content_frame, new DecimoFragment()).commit();

        }else if (id == R.id.nav_11) {
            fm.beginTransaction().replace(R.id.content_frame, new DecimoPrimeroFragment()).commit();

        }else if (id == R.id.nav_12) {
            fm.beginTransaction().replace(R.id.content_frame, new DoceFragment()).commit();

        }else if (id == R.id.nav_13) {
            fm.beginTransaction().replace(R.id.content_frame, new treceFragment()).commit();

        } else if (id == R.id.nav_14) {
            fm.beginTransaction().replace(R.id.content_frame, new catorceFragment()).commit();

        }else if (id == R.id.nav_15) {
            fm.beginTransaction().replace(R.id.content_frame, new quinceFragment()).commit();

        }else if (id == R.id.nav_16) {
            fm.beginTransaction().replace(R.id.content_frame, new DieciseisFragment()).commit();

        }else if (id == R.id.nav_17) {
            fm.beginTransaction().replace(R.id.content_frame, new DiecisieteFragment()).commit();

        }else if (id == R.id.nav_18) {
            fm.beginTransaction().replace(R.id.content_frame, new DieciochoFragment()).commit();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
