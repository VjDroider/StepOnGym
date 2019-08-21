package com.stepon.gymapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stepon.gymapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DietDetailFragment extends Fragment {

    private String strTitle;
    private String strDetail;

    @BindView(R.id.tvDietDetailTitle)
    protected TextView tvDietDetailTitle;
    @BindView(R.id.tvDietDetailDetail)
    protected TextView tvDietDetailDetail;

    public static DietDetailFragment newInstance(String strTitle, String strDetail) {

        DietDetailFragment fragment = new DietDetailFragment();
        fragment.strTitle = strTitle;
        fragment.strDetail = strDetail;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet_detail, container, false);
        ButterKnife.bind(this,view);
        initFrag();
        return view;
    }

    private void initFrag(){
        tvDietDetailTitle.setText(strTitle);
        Spanned htmlAsSpanned = Html.fromHtml(strDetail);
        tvDietDetailDetail.setText(htmlAsSpanned);
    }

}
