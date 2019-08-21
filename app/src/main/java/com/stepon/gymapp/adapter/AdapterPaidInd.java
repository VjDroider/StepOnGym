package com.stepon.gymapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stepon.gymapp.R;
import com.stepon.gymapp.activity.PaidDetailActivity;
import com.stepon.gymapp.model.paid.ModelInd;
import com.stepon.gymapp.payumoney.PaymentActivity;
import com.stepon.gymapp.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPaidInd extends RecyclerView.Adapter<AdapterPaidInd.IndViewHolder> {

    private Context tContext;
    private List<ModelInd> tModels;

    public AdapterPaidInd(Context tContext, List<ModelInd> tModels) {
        this.tContext = tContext;
        this.tModels = tModels;
    }

    @NonNull
    @Override
    public IndViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_paid_indivisual, viewGroup, false);
        return new IndViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull IndViewHolder indViewHolder, int i) {
        final ModelInd tModel = tModels.get(i);
        indViewHolder.tvPaidIndTitle.setText(tModel.getPackageName());
        indViewHolder.tvPaidIndPrice.setText(tModel.getPrice());
        indViewHolder.btnPaidInd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tIntent = new Intent(tContext, PaymentActivity.class);
                tIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                tIntent.putExtra(Constant.PAID_TITLE, tModel.getPackageName());
                tIntent.putExtra(Constant.PAID_DETAIL, tModel.getPackageDetail());
                tIntent.putExtra(Constant.PAID_PRICE, tModel.getPrice());
                tContext.startActivity(tIntent);
            }
        });



    }
    @Override
    public int getItemCount() {
        return tModels.size();
    }

    public class IndViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvPaidIndTitle)
        protected TextView tvPaidIndTitle;
        @BindView(R.id.tvPaidIndPrice)
        protected TextView tvPaidIndPrice;
        @BindView(R.id.btnPaidInd)
        protected Button btnPaidInd;
        @BindView(R.id.llPaidInd)
        protected LinearLayout llPaidInd;
        public IndViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
