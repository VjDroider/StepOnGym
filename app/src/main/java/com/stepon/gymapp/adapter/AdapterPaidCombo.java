package com.stepon.gymapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stepon.gymapp.R;
import com.stepon.gymapp.model.paid.ModelCombo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPaidCombo extends RecyclerView.Adapter<AdapterPaidCombo.ComboViewHolder> {

    private Context tContext;
    private List<ModelCombo> tModels;

    public AdapterPaidCombo(Context tContext, List<ModelCombo> tModels) {
        this.tContext = tContext;
        this.tModels = tModels;
    }

    @NonNull
    @Override
    public ComboViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_paid_combo, viewGroup, false);
        return new ComboViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ComboViewHolder comboViewHolder, int i) {

        ModelCombo tModel = tModels.get(i);
        comboViewHolder.tvPaidComboTitle.setText(tModel.getPackageName());
        comboViewHolder.tvPaidComboPrice.setText(tModel.getPrice());
        comboViewHolder.btnPaidCombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @Override
    public int getItemCount() {
        return tModels.size();
    }

    public class ComboViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvPaidComboTitle)
        protected TextView tvPaidComboTitle;
        @BindView(R.id.tvPaidComboPrice)
        protected TextView tvPaidComboPrice;
        @BindView(R.id.btnPaidCombo)
        protected Button btnPaidCombo;
        @BindView(R.id.llPaidCombo)
        protected LinearLayout llPaidCombo;

        public ComboViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
