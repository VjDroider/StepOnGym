package com.stepon.gymapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stepon.gymapp.R;
import com.stepon.gymapp.fragment.DietFragment;

public class DietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        getSupportFragmentManager().beginTransaction().replace(R.id.diet_container, new DietFragment()).commit();
    }
}
