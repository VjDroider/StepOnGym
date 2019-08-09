package com.stepon.gymapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.stepon.gymapp.R;
import com.stepon.gymapp.RetrofitClient;
import com.stepon.gymapp.activity.DetailActivity;
import com.stepon.gymapp.adapter.AdapterWeek;
import com.stepon.gymapp.model.ModelCategory;
import com.stepon.gymapp.model.ModelWeek;
import com.stepon.gymapp.utils.Constant;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {
    private Context tContext;
    private static final String ARG_SECTION_NUMBER = "section_number";
    private int sectionNumber;
    private List<ModelCategory> tModelsCategory;
    private List<ModelWeek> tModelsWeek;
    private RecyclerView.LayoutManager tLauyoutManager;
    private AdapterWeek tAdapterWeek;
    private String strCatId;

    private SparseArray<WeakReference<MainFragment>> mFragments;


    @BindView(R.id.tvFragTitle)
    protected TextView tvFragTitle;
    @BindView(R.id.rvFragMain)
    protected RecyclerView rvFragMain;
    @BindView(R.id.pbMainFragment)
    protected ProgressBar pbMainFragment;

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
        tvFragTitle.setText(tModelsCategory.get(sectionNumber-1).getName());
        strCatId = tModelsCategory.get(sectionNumber-1).getId();
        Log.d(Constant.TAG, "Cat Id :"+strCatId);
        Log.d(Constant.TAG, "Cat Name :"+tModelsCategory.get(sectionNumber-1).getName());

        initFrag();
        return  view;
    }

    public static MainFragment newInstance(int sectionNumber, List<ModelCategory> tModelsCategory) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        fragment.tModelsCategory = tModelsCategory;
        return fragment;
    }

    private void initFrag(){
        tContext = getContext();
        tLauyoutManager = new LinearLayoutManager(tContext);
        rvFragMain.setLayoutManager(tLauyoutManager);
        pbMainFragment.setVisibility(View.VISIBLE);
        callApi();
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

            // Fetch data or something...
        }
    }
    private void callApi(){
        Call<List<ModelWeek>> call = RetrofitClient.getInstance().getApi().getWeek(strCatId);
        call.enqueue(new Callback<List<ModelWeek>>() {
            @Override
            public void onResponse(Call<List<ModelWeek>> call, Response<List<ModelWeek>> response) {
                tModelsWeek = response.body();
                pbMainFragment.setVisibility(View.GONE);
                Log.d(Constant.TAG, "Week Size : "+tModelsWeek.size());

                if (tModelsWeek.size()!=0){
                    tAdapterWeek = new AdapterWeek(tContext, tModelsWeek, tModelsCategory, sectionNumber-1);
                    rvFragMain.setAdapter(tAdapterWeek);
                }
//                else{
//                    Intent tIntent = new Intent(tContext, DetailActivity.class);
//                    tIntent.putExtra(Constant.WEEK_ID, "");
//                    tIntent.putExtra(Constant.CAT_ID, strCatId);
//                    tContext.startActivity(tIntent);
//
//
//                }
            }

            @Override
            public void onFailure(Call<List<ModelWeek>> call, Throwable t) {

                Log.d(Constant.TAG, "Failure Week Response : "+t);
            }
        });
    }
}
