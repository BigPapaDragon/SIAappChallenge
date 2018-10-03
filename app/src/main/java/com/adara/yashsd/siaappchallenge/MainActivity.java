package com.adara.yashsd.siaappchallenge;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Animation anim1,anim2,anim3,anim4;
    Boolean isOpen = false;

    FloatingActionButton fab,fb2,fb3,fb4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fb2 = (FloatingActionButton) findViewById(R.id.fab1);
        fb3 = (FloatingActionButton) findViewById(R.id.fab2);
        fb4 = (FloatingActionButton) findViewById(R.id.fab3);

        fb2.setVisibility(View.INVISIBLE);
        fb2.setClickable(false);
        fb3.setVisibility(View.INVISIBLE);
        fb3.setClickable(false);
        fb4.setVisibility(View.INVISIBLE);
        fb4.setClickable(false);
        anim1 = AnimationUtils.loadAnimation(this,R.anim.fba_open);
        anim2 = AnimationUtils.loadAnimation(this,R.anim.fba_close);
        anim3 = AnimationUtils.loadAnimation(this,R.anim.rotate_open);
        anim4 = AnimationUtils.loadAnimation(this,R.anim.rotate_close);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isOpen == false)
                {
                    fab.startAnimation(anim3);
                    fb2.startAnimation(anim1);
                    fb3.startAnimation(anim1);
                    fb4.startAnimation(anim1);
                    fb2.setClickable(true);
                    fb3.setClickable(true);
                    fb4.setClickable(true);
                    isOpen = true;
                }
                else if(isOpen == true)
                {
                    fab.startAnimation(anim4);
                    fb2.startAnimation(anim2);
                    fb3.startAnimation(anim2);
                    fb4.startAnimation(anim2);
                    fb2.setClickable(false);
                    fb3.setClickable(false);
                    fb4.setClickable(false);
                    isOpen = false;
                }
            }
        });

        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return false;
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.navigation_header_container);
        ImageView iv = (ImageView)linearLayout.findViewById(R.id.imageView);
        TextView tv1 = (TextView)linearLayout.findViewById(R.id.nav_bar_text1);
        TextView tv2 = (TextView)linearLayout.findViewById(R.id.nav_bar_text2);

        CoordinatorLayout coordinatorLayout = (CoordinatorLayout)findViewById(R.id.appbarmain);
        LinearLayout linearLayout1 = (LinearLayout)coordinatorLayout.findViewById(R.id.LinMain);

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_admin) {
            iv.setImageResource(R.mipmap.nav_draw_admin);
            tv1.setText("Admin");
            tv2.setText(R.string.nav_admin);

            linearLayout1.removeAllViews();

            LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
            View childLayout = inflater.inflate(R.layout.app_bar_admin, (ViewGroup) findViewById(R.id.appbaradmin));
            linearLayout1.addView(childLayout);

            /*LinearLayout linearLayout2 = (LinearLayout)findViewById(R.id.appbaradmin);
            ListView lv = (ListView)linearLayout2.findViewById(R.id.lv);

            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
            databaseAccess.open();
            List<String> orgair = databaseAccess.getAllOrginAirFlights();
            List<String> orgcity = databaseAccess.getAllOrginCityFlights();
            List<String> destair = databaseAccess.getAllestAirFlights();
            List<String> destcity = databaseAccess.getAllDestCityFlights();
            databaseAccess.close();

            String[] orgairarr = new String[orgair.size()];
            orgairarr = orgair.toArray(orgairarr);

            String[] orgcityarr = new String[orgcity.size()];
            orgcityarr = orgcity.toArray(orgcityarr);

            String[] destairarr = new String[destair.size()];
            destairarr = destair.toArray(destairarr);

            String[] destcityarr = new String[destcity.size()];
            destcityarr = destcity.toArray(destcityarr);

            customadapt ca = new customadapt(MainActivity.this,orgairarr,orgcityarr,destairarr,destcityarr);
            lv.setAdapter(ca);*/

        } else if (id == R.id.nav_passenger) {
            iv.setImageResource(R.mipmap.nav_draw_passenger);
            tv1.setText("Passenger");
            tv2.setText(R.string.nav_passenger);

            linearLayout1.removeAllViews();

            LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
            View childLayout = inflater.inflate(R.layout.app_bar_passenger, (ViewGroup) findViewById(R.id.appbarpassenger));
            linearLayout1.addView(childLayout);
        } else if (id == R.id.nav_groundstaff) {
            iv.setImageResource(R.mipmap.nav_draw_ground_staff);
            tv1.setText("Ground staff");
            tv2.setText(R.string.nav_ground_staff);

            linearLayout1.removeAllViews();

            LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
            View childLayout = inflater.inflate(R.layout.app_bar_ground_staff, (ViewGroup) findViewById(R.id.appbargroundstaff));
            linearLayout1.addView(childLayout);
        } else if (id == R.id.nav_flightcrew) {
            iv.setImageResource(R.mipmap.nav_draw_flight_crew);
            tv1.setText("Flight Crew");
            tv2.setText(R.string.nav_flight_crew);

            linearLayout1.removeAllViews();

            LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
            View childLayout = inflater.inflate(R.layout.app_bar_flightcrew, (ViewGroup) findViewById(R.id.appbarflightcrew));
            linearLayout1.addView(childLayout);
        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
