package com.stepon.gymapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stepon.gymapp.R;
import com.stepon.gymapp.RetrofitClient;
import com.stepon.gymapp.adapter.AdapterWeek;
import com.stepon.gymapp.model.ModelCategory;
import com.stepon.gymapp.model.ModelWeek;
import com.stepon.gymapp.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {
    private Context tCcontext;
    private static final String ARG_SECTION_NUMBER = "section_number";
    private int sectionNumber;
    private List<ModelCategory> tModels;
    private RecyclerView.LayoutManager tLauyoutManager;
    private AdapterWeek tAdapterWeek;

    @BindView(R.id.tvFragTitle)
    protected TextView tvFragTitle;
    @BindView(R.id.rvFragMain)
    protected RecyclerView rvFragMain;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sectionNumber = getArguments() != null ? getArguments().getInt(ARG_SECTION_NUMBER) : 1;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_main, container, false);
        ButterKnife.bind(this, view);
        tvFragTitle.setText(tModels.get(sectionNumber-1).getName());
        initFrag();
        return  view;
    }

    public static MainFragment newInstance(int sectionNumber, List<ModelCategory> tModels) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        fragment.tModels = tModels;
        return fragment;
    }

    private void initFrag(){
        tCcontext = getContext();
        tLauyoutManager = new LinearLayoutManager(tCcontext);
        rvFragMain.setLayoutManager(tLauyoutManager);
        callApi();
    }

    private void callApi(){
        Call<List<ModelWeek>> call = RetrofitClient.getInstance().getApi().getWeek();
        call.enqueue(new Callback<List<ModelWeek>>() {
            @Override
            public void onResponse(Call<List<ModelWeek>> call, Response<List<ModelWeek>> response) {
                List<ModelWeek> tModels = response.body();
                tAdapterWeek = new AdapterWeek(tCcontext, tModels);
                rvFragMain.setAdapter(tAdapterWeek);
            }

            @Override
            public void onFailure(Call<List<ModelWeek>> call, Throwable t) {

                Log.d(Constant.TAG, "Failure Week Response : "+t);
            }
        });
    }
}
