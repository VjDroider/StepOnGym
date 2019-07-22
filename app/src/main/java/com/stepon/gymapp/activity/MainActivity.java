package com.stepon.gymapp.activity;
import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.WindowManager;

import com.stepon.gymapp.Fragment.AboutUsFragment;
import com.stepon.gymapp.Fragment.ChildFragment;
import com.stepon.gymapp.Fragment.DietFragment;
import com.stepon.gymapp.Fragment.ExcerciseFragment;
import com.stepon.gymapp.Fragment.GymFragment;
import com.stepon.gymapp.Fragment.MenFragment;
import com.stepon.gymapp.Fragment.WieghtFragment;
import com.stepon.gymapp.Fragment.WomenFragment;
import com.stepon.gymapp.R;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    TabLayout myTab;
    ViewPager myViewPager;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//TabLayout
        myTab = findViewById(R.id.view);
        myViewPager = findViewById(R.id.mypager);
        myViewPager.setAdapter(new MyOwnPagerAdapter(getSupportFragmentManager()));
        myTab.setupWithViewPager(myViewPager);

        myTab.setTabTextColors(
                getResources().getColor(R.color.white),
                getResources().getColor(R.color.white));

        myTab.setSelectedTabIndicatorColor(R.color.white);


        myTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                myViewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //tablayout code finish

        // remove status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //drawer layout
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    class MyOwnPagerAdapter extends FragmentPagerAdapter {

        String data[] = {"Home", "Men", "Women", "Gym", "Diet", "Weight", "Child", "AboutUs"};


        public MyOwnPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {

                return new MenFragment();
            }


            if (position == 1) {

                return new WomenFragment();

            }
            if (position == 2) {

                return new ChildFragment();
            }
            if (position == 3) {

                return new GymFragment();
            }

            if (position == 4) {

                return new DietFragment();
            }


            if (position == 5) {

                return new WieghtFragment();
            }


            if (position == 6) {

                return new ExcerciseFragment();
            }

            if (position == 7) {

                return new AboutUsFragment();
            }

            return null;
        }

        @Override
        public int getCount() {
            return data.length;
        }


        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return data[position];
        }
    }
}
