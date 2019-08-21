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
import android.widget.ProgressBar;

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
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;

    private MainPagerAdapter tPagerAdapter;
    private SharedPrefManager tSharedPrefManager;
    private Context tContext;
    @BindView(R.id.toolbar_detail)
    protected Toolbar toolbar;
    @BindView(R.id.mypager)
    protected ViewPager tViewPager;
    @BindView(R.id.tabs)
    protected TabLayout tTabLayout;
    @BindView(R.id.pbMainActivity)
    protected ProgressBar pbMainActivity;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initActivity();
        setSupportActionBar(toolbar);
        initDrawer(toolbar);



        callApi();

    }
    private void initActivity(){
        tContext = MainActivity.this;
        tSharedPrefManager = new SharedPrefManager(tContext);
        pbMainActivity.setVisibility(View.VISIBLE);
    }




    private void callApi(){
       Call<List<ModelCategory>> call = RetrofitClient.getInstance().getApi().getCategory();
       call.enqueue(new Callback<List<ModelCategory>>() {
           @Override
           public void onResponse(Call<List<ModelCategory>> call, Response<List<ModelCategory>> response) {
               List<ModelCategory> tModels = response.body();
               pbMainActivity.setVisibility(View.GONE);

                   tPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), tModels);
                   tViewPager.setAdapter(tPagerAdapter);
                   tTabLayout.setupWithViewPager(tViewPager);
//               }
//               else {
//                   Toast.makeText(MainActivity.this, "No data is responding from server", Toast.LENGTH_LONG).show();
//               }

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
            startActivity(new Intent(MainActivity.this, MainActivity.class));
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_diet) {
            startActivity(new Intent(MainActivity.this, DietActivity.class));
        } else if (id == R.id.nav_share) {
            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "StepOn");
                String shareMessage= "\nLet me recommend you StepOn Application for best Gym training at home.\nDownload the app by the given link\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + Constant.APP_ID +"\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "Share by"));
            } catch(Exception e) {
                //e.toString();
            }
        } else if (id == R.id.nav_paid) {

            startActivity(new Intent(MainActivity.this, PaidActivity.class));
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
