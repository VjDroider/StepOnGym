package com.stepon.gymapp.activity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.stepon.gymapp.R;
import com.stepon.gymapp.storage.SharedPrefManager;
import com.stepon.gymapp.adapter.MyPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, TabLayout.OnTabSelectedListener {


    private SharedPrefManager tSharedPrefManager;
    private Context tContext;
    @BindView(R.id.mypager)
    protected ViewPager myViewPager;
    @BindView(R.id.view)
    protected TabLayout myTab;
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    private ImageView ivLogout;
    @BindView(R.id.container_main)
    protected FrameLayout tLayout;



    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        initActivity();
        initTab();
        initDrawer(toolbar);


    }
    private void initActivity(){
        tLayout.setVisibility(View.VISIBLE);
        tContext = MainActivity.this;
        tSharedPrefManager = new SharedPrefManager(tContext);
    }

    @SuppressLint("ResourceAsColor")
    private void initTab(){
        myViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), ""));
        myTab.setupWithViewPager(myViewPager);

        myTab.setTabTextColors(
                getResources().getColor(R.color.white),
                getResources().getColor(R.color.white));
        myTab.setSelectedTabIndicatorColor(R.color.white);
        myTab.addOnTabSelectedListener(this);
        // remove status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void initDrawer(Toolbar toolbar){
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

    @OnClick(R.id.ivLogout)
    public void ivLogoutClicked(View view){
    tSharedPrefManager.clearUserData();
    startActivity(new Intent(MainActivity.this, LoginActivity.class));
}


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
}
