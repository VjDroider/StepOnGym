package com.stepon.gymapp.activity;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.stepon.gymapp.R;
import com.stepon.gymapp.RetrofitClient;
import com.stepon.gymapp.adapter.AdapterDetail;
import com.stepon.gymapp.model.login.ModelDetail;
import com.stepon.gymapp.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private Context tContext;
    private RecyclerView.LayoutManager tLayoutManager;
    private AdapterDetail tAdapterDetail;
    private String strWeekId;
    private String strCatId;
    private FragmentManager tFragmentManager;


    @BindView(R.id.rvDetail)
    protected RecyclerView rvDetail;
    @BindView(R.id.pbDetailActivity)
    protected ProgressBar pbDetailActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        initActivity();
    }

    private void initActivity(){
        tContext = DetailActivity.this;
        tLayoutManager = new LinearLayoutManager(this);
        rvDetail.setLayoutManager(tLayoutManager);
        tFragmentManager = getSupportFragmentManager();
        pbDetailActivity.setVisibility(View.VISIBLE);
        callApi();
    }

    private void callApi(){
        strWeekId = getIntent().getStringExtra(Constant.WEEK_ID);
        strCatId = getIntent().getStringExtra(Constant.CAT_ID);
        Log.d(Constant.TAG, "Week Id : "+strWeekId);
        Log.d(Constant.TAG, "Cat Id : "+strCatId);
        Call<List<ModelDetail>> call = RetrofitClient.getInstance().getApi().getDetail(strWeekId, strCatId);
        call.enqueue(new Callback<List<ModelDetail>>() {
            @Override
            public void onResponse(Call<List<ModelDetail>> call, Response<List<ModelDetail>> response) {
                List<ModelDetail> tModels = response.body();
                pbDetailActivity.setVisibility(View.GONE);
                tAdapterDetail = new AdapterDetail(tContext, tModels, tFragmentManager);
                rvDetail.setAdapter(tAdapterDetail);
            }

            @Override
            public void onFailure(Call<List<ModelDetail>> call, Throwable t) {

            }
        });
    }
}
