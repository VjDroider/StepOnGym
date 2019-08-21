package com.stepon.gymapp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.stepon.gymapp.R;
import com.stepon.gymapp.RetrofitClient;
import com.stepon.gymapp.model.login.ModelDetail;
import com.stepon.gymapp.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private List<ModelDetail> tModels;
    private String strWeekName;
    private String strWeekId;
    private String strCatId;

    private boolean tSunday = false;
    private boolean tMonday = false;
    private boolean tTuesday = false;
    private boolean tWednesday = false;
    private boolean tThursday = false;
    private boolean tFriday = false;
    private boolean tSaturday = false;


    @BindView(R.id.tvDaySunday)
    protected TextView tvDaySunday;
    @BindView(R.id.tvDayMonday)
    protected TextView tvDayMonday;
    @BindView(R.id.tvDayTuesday)
    protected TextView tvDayTuesday;
    @BindView(R.id.tvDayWednesday)
    protected TextView tvDayWednesday;
    @BindView(R.id.tvDayThursday)
    protected TextView tvDayThursday;
    @BindView(R.id.tvDayFriday)
    protected TextView tvDayFriday;
    @BindView(R.id.tvDaySaturday)
    protected TextView tvDaySaturday;
    @BindView(R.id.tvDetailToolbar)
    protected TextView tvDetailToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        initActivity();
    }

    private void initActivity(){
        strWeekId = getIntent().getStringExtra(Constant.WEEK_ID);
        strWeekName = getIntent().getStringExtra(Constant.WEEK_NAME);
        strCatId = getIntent().getStringExtra(Constant.CAT_ID);
        tvDetailToolbar.setText(strWeekName);
        callApi();
    }

    private void dataSend(String strDay){
        Intent tIntent = new Intent(DetailActivity.this, DayWorkActivity.class);
        tIntent.putExtra(Constant.WEEK_ID, strWeekId);
        tIntent.putExtra(Constant.CAT_ID, strCatId);
        tIntent.putExtra(Constant.DAY, strDay);
        startActivity(tIntent);
    }
    private void callApi(){
        Log.d(Constant.TAG, "Week Id : "+strWeekId);
        Log.d(Constant.TAG, "Cat Id : "+strCatId);
        Call<List<ModelDetail>> call = RetrofitClient.getInstance().getApi().getDetail(strWeekId, strCatId);

        call.enqueue(new Callback<List<ModelDetail>>() {
    @Override
    public void onResponse(Call<List<ModelDetail>> call, Response<List<ModelDetail>> response) {
        tModels = response.body();
        for (int i = 0 ; i<tModels.size(); i++){

            Log.d(Constant.TAG, "Day Name : "+tModels.get(i).getDay());
            if (tModels.get(i).getDay().contains("Sunday")){
                tSunday = true;
            }
            if (tModels.get(i).getDay().contains("Monday")) {
                tMonday = true;
            }
            if (tModels.get(i).getDay().contains("Tuesday")) {
                tTuesday = true;
            }
            if (tModels.get(i).getDay().contains("Wednesday")) {
                tWednesday = true;
            }
            if (tModels.get(i).getDay().contains("Thursday")) {
                tThursday = true;
            }
            if (tModels.get(i).getDay().contains("Friday")) {
                tFriday = true;
            }
            if (tModels.get(i).getDay().contains("Saturday")) {
                tSaturday = true;
            }

        }


        if (tSunday){
            tvDaySunday.setVisibility(View.VISIBLE);
        }
        if (tMonday){
            tvDayMonday.setVisibility(View.VISIBLE);
        }

        if (tTuesday){
            tvDayTuesday.setVisibility(View.VISIBLE);
        }
        if (tWednesday){
            tvDayWednesday.setVisibility(View.VISIBLE);
        }
        if (tThursday){
            tvDayThursday.setVisibility(View.VISIBLE);
        }
        if (tFriday){
            tvDayFriday.setVisibility(View.VISIBLE);
        }
        if (tSaturday){
            tvDaySaturday.setVisibility(View.VISIBLE);
        }
        if (tSunday){
            tvDaySunday.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onFailure(Call<List<ModelDetail>> call, Throwable t) {

    }
});    }

    @OnClick(R.id.tvDaySunday)
    public void tvDaySundayClicked(View view){
        dataSend("Sunday");
    }
    @OnClick(R.id.tvDayMonday)
    public void tvDayMondayClicked(View view){
        dataSend("Monday");
    }
    @OnClick(R.id.tvDayTuesday)
    public void tvDayTuesdayClicked(View view){
        dataSend("Tuesday");
    }
    @OnClick(R.id.tvDayWednesday)
    public void tvDayWednesdayClicked(View view){
        dataSend("Wednesday");
    }
    @OnClick(R.id.tvDayThursday)
    public void tvDayThursdayClicked(View view){
        dataSend("Thursday");
    }
    @OnClick(R.id.tvDayFriday)
    public void tvDayFridayClicked(View view){
        dataSend("Friday");
    }
    @OnClick(R.id.tvDaySaturday)
    public void tvDaySaturdayClicked(View view){
        dataSend("Saturday");
    }

}
