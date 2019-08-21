package com.stepon.gymapp.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.stepon.gymapp.R;
import com.stepon.gymapp.RetrofitClient;
import com.stepon.gymapp.adapter.AdapterDayWork;
import com.stepon.gymapp.model.ModelDayWork;
import com.stepon.gymapp.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DayWorkActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager tLayoutManager;
    private AdapterDayWork tAdapter;
    private  List<ModelDayWork> tModels;
    private String strWeekId;
    private String strCatId;
    private String strDay;
    private String strWorkoutVideo;
    private Context tContext;

    @BindView(R.id.tvDayWorkDay)
    protected TextView tvDayWorkDay;
    @BindView(R.id.rvDayWork)
    protected RecyclerView rvDayWork;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_work);
        ButterKnife.bind(this);
        initActivity();
    }

    private void initActivity(){
        tContext = DayWorkActivity.this;
        strWeekId = getIntent().getStringExtra(Constant.WEEK_ID);
        strCatId = getIntent().getStringExtra(Constant.CAT_ID);
        strDay = getIntent().getStringExtra(Constant.DAY);
        tvDayWorkDay.setText(strDay);
        tLayoutManager = new LinearLayoutManager(this);
        rvDayWork.setLayoutManager(tLayoutManager);
        callApi();
    }
    private void callApi(){
        Log.d(Constant.TAG, "Week Id : "+strWeekId);
        Log.d(Constant.TAG, "Cat Id : "+strCatId);
        Call<List<ModelDayWork>> call = RetrofitClient.getInstance().getApi().getDayWork(strWeekId, strCatId,strDay);
        call.enqueue(new Callback<List<ModelDayWork>>() {
            @Override
            public void onResponse(Call<List<ModelDayWork>> call, Response<List<ModelDayWork>> response) {
                tModels = response.body();
                tAdapter = new AdapterDayWork(tContext, tModels);
                rvDayWork.setAdapter(tAdapter);
            }

            @Override
            public void onFailure(Call<List<ModelDayWork>> call, Throwable t) {

            }
        });
    }

}
