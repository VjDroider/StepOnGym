package com.stepon.gymapp.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.stepon.gymapp.R;
import com.stepon.gymapp.RetrofitClient;
import com.stepon.gymapp.adapter.AdapterPaidCombo;
import com.stepon.gymapp.adapter.AdapterPaidInd;
import com.stepon.gymapp.model.paid.ModelCombo;
import com.stepon.gymapp.model.paid.ModelInd;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaidActivity extends AppCompatActivity {

    private Context tContext;
    private RecyclerView.LayoutManager tManagerInd;
    private RecyclerView.LayoutManager tManagerCombo;

    private AdapterPaidCombo tAdapterCombo;
    private AdapterPaidInd tAdapterInd;

    @BindView(R.id.rvPaidIndividual)
    protected RecyclerView rvPaidInd;

    @BindView(R.id.rvPaidCombo)
    protected RecyclerView rvPaidCombo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid);
        ButterKnife.bind(this);
        initActivity();
        callIndApi();
        callComboApi();
    }

    private void initActivity(){
        tContext = getApplicationContext();
        tManagerCombo = new LinearLayoutManager(this);
        rvPaidCombo.setLayoutManager(tManagerCombo);
        tManagerInd = new LinearLayoutManager(this);
        rvPaidInd.setLayoutManager(tManagerInd);



    }

    private void callIndApi(){
        Call<List<ModelInd>> callInd = RetrofitClient.getInstance().getApi().getIndPcakage();
        callInd.enqueue(new Callback<List<ModelInd>>() {
            @Override
            public void onResponse(Call<List<ModelInd>> call, Response<List<ModelInd>> response) {
                List<ModelInd> tModels = response.body();
                tAdapterInd = new AdapterPaidInd(tContext, tModels);
                rvPaidInd.setAdapter(tAdapterInd);
            }

            @Override
            public void onFailure(Call<List<ModelInd>> call, Throwable t) {

            }
        });
    }
    private void callComboApi(){
        Call<List<ModelCombo>> callInd = RetrofitClient.getInstance().getApi().getComboPackage();
        callInd.enqueue(new Callback<List<ModelCombo>>() {
            @Override
            public void onResponse(Call<List<ModelCombo>> call, Response<List<ModelCombo>> response) {
                List<ModelCombo> tModels = response.body();
                tAdapterCombo = new AdapterPaidCombo(tContext, tModels);
                rvPaidCombo.setAdapter(tAdapterCombo);
            }

            @Override
            public void onFailure(Call<List<ModelCombo>> call, Throwable t) {

            }
        });
    }
}
