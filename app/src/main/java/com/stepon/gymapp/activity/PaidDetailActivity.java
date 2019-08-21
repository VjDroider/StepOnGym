package com.stepon.gymapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.stepon.gymapp.R;
import com.stepon.gymapp.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaidDetailActivity extends AppCompatActivity {

    @BindView(R.id.tvPaidDetailTitle)
    protected TextView tvPaidDetailTitle;
    @BindView(R.id.tvPaidDetailDetail)
    protected TextView tvPaidDetailDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid_detail);
        ButterKnife.bind(this);
        String strTitle = getIntent().getStringExtra(Constant.PAID_TITLE);
        String strDetail = getIntent().getStringExtra(Constant.PAID_DETAIL);
        tvPaidDetailTitle.setText(strTitle);
        Spanned htmlAsSpanned = Html.fromHtml(strDetail);
        tvPaidDetailDetail.setText(htmlAsSpanned);
    }
}
