package com.stepon.gymapp.activity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.stepon.gymapp.Api;
import com.stepon.gymapp.R;
import com.stepon.gymapp.RetrofitClient;
import com.stepon.gymapp.adapter.MainPagerAdapter;
import com.stepon.gymapp.model.ModelCategory;
import com.stepon.gymapp.storage.SharedPrefManager;
import com.stepon.gymapp.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private TabLayout tTabLayout;
    private ViewPager tViewPager;
    private MainPagerAdapter tPagerAdapter;

    private int noOfTabs = 10;

    private SharedPrefManager tSharedPrefManager;
    private Context tContext;

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;





    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        initActivity();
        initDrawer(toolbar);


    }
    private void initActivity(){
        tContext = MainActivity.this;
        tSharedPrefManager = new SharedPrefManager(tContext);
callApi();
    }

    private void callApi(){
       Call<List<ModelCategory>> call = RetrofitClient.getInstance().getApi().getCategory();
       call.enqueue(new Callback<List<ModelCategory>>() {
           @Override
           public void onResponse(Call<List<ModelCategory>> call, Response<List<ModelCategory>> response) {
               List<ModelCategory> tModels = response.body();
               tPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), tModels);
               tViewPager = findViewById(R.id.mypager);
               tViewPager.setAdapter(tPagerAdapter);
               tTabLayout = findViewById(R.id.tabs);
               tTabLayout.setupWithViewPager(tViewPager);
           }

           @Override
           public void onFailure(Call<List<ModelCategory>> call, Throwable t) {

               Log.d(Constant.TAG, "Failure Category Response : "+t);
           }
       });
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


}
