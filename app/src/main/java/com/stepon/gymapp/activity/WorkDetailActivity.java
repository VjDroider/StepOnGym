package com.stepon.gymapp.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;

import com.stepon.gymapp.R;
import com.stepon.gymapp.model.ModelDayWork;
import com.stepon.gymapp.model.login.ModelDetail;
import com.stepon.gymapp.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkDetailActivity extends AppCompatActivity {
    @BindView(R.id.tvActivityWorkTitle)
    protected TextView tvActivityWorkTitle;
    @BindView(R.id.tvActivityWorkDetail)
    protected TextView tvActivityWorkDetail;

    private ModelDayWork tModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_detail);
        ButterKnife.bind(this);
        tModel = (ModelDayWork) getIntent().getSerializableExtra("ModelDetail");
        tvActivityWorkTitle.setText(tModel.getWorkoutTitle());
        Spanned htmlAsSpanned = Html.fromHtml(tModel.getWorkoutDetail());
        tvActivityWorkDetail.setText(htmlAsSpanned);

    }
}
