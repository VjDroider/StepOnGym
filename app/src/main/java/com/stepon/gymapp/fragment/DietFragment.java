package com.stepon.gymapp.fragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.stepon.gymapp.R;
import com.stepon.gymapp.RetrofitClient;
import com.stepon.gymapp.adapter.AdapterDietList;
import com.stepon.gymapp.model.ModelDiet;
import com.stepon.gymapp.model.login.ModelDetail;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DietFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private Context tContext;
    private FragmentManager tFragmentManager;
    private RecyclerView.LayoutManager tManager;
    private AdapterDietList tAdapter;
    @BindView(R.id.srlDietList)
    protected SwipeRefreshLayout srlDietList;
    @BindView(R.id.rvDietList)
    protected RecyclerView rvDietList;
    @BindView(R.id.pbDietList)
    protected ProgressBar pbDietList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_diet, container, false);
        ButterKnife.bind(this, view);
        srlDietList.setOnRefreshListener(this);
        initFrag();
        return view;
    }

    private void initFrag(){
        tContext = getContext();
        tFragmentManager = getFragmentManager();
        tManager = new LinearLayoutManager(tContext);
        rvDietList.setLayoutManager(tManager);
        callApi();

    }

    private void callApi(){
        Call<List<ModelDiet>> call = RetrofitClient.getInstance().getApi().getDietList();
        call.enqueue(new Callback<List<ModelDiet>>() {
            @Override
            public void onResponse(Call<List<ModelDiet>> call, Response<List<ModelDiet>> response) {
                pbDietList.setVisibility(View.GONE);
                List<ModelDiet> tModels = response.body();
                tAdapter = new AdapterDietList(tContext, tModels, tFragmentManager);
                rvDietList.setAdapter(tAdapter);
            }

            @Override
            public void onFailure(Call<List<ModelDiet>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                srlDietList.setRefreshing(false);
            }
        }, 2000);
    }
}
