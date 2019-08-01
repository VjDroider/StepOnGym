package com.stepon.gymapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stepon.gymapp.R;
import com.stepon.gymapp.activity.DetailActivity;
import com.stepon.gymapp.activity.MainActivity;
import com.stepon.gymapp.activity.VideoActivity;
import com.stepon.gymapp.model.ModelWeek;
import com.stepon.gymapp.model.login.ModelDetail;
import com.stepon.gymapp.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDetail extends RecyclerView.Adapter<AdapterDetail.DetailViewHolder> {

    private Context tContext;
    private List<ModelDetail> tModelsDetail;

    public AdapterDetail(Context tContext, List<ModelDetail> tModelsDetail) {
        this.tContext = tContext;
        this.tModelsDetail = tModelsDetail;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detail_item, viewGroup, false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder detailViewHolder, int i) {

        ModelDetail tModelDetail = tModelsDetail.get(i);
        String strWeek = tModelDetail.getDay();
        detailViewHolder.tvDayDetail.setText(strWeek);

      final String  strChestUrl = Constant.VID_URL+tModelDetail.getChestVideo();
        final String  strBicepsUrl = Constant.VID_URL+tModelDetail.getBicepsVideo();
        final String  strShoulderUrl = Constant.VID_URL+tModelDetail.getShoulderVideo();
        final String  strTricepsUrl = Constant.VID_URL+tModelDetail.getTricepsVideo();


        detailViewHolder.tvDetailChest.setText("Chest");
        detailViewHolder.tvDetailBiceps.setText("Biceps");
        detailViewHolder.tvDetailShoulder.setText("Shoulder");
        detailViewHolder.tvDetailTriceps.setText("Triceps");

        detailViewHolder.tvDetailChest .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chestIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(strChestUrl));
                tContext.startActivity(chestIntent);
            }
        });
        detailViewHolder.tvDetailBiceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bicepsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(strBicepsUrl));
                tContext.startActivity(bicepsIntent);
            }
        });
        detailViewHolder.tvDetailShoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shoulderIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(strShoulderUrl));
                tContext.startActivity(shoulderIntent);
            }
        });
        detailViewHolder.tvDetailTriceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tricepsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(strTricepsUrl));
                tContext.startActivity(tricepsIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tModelsDetail.size();
    }


    public class DetailViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvDayDetail)
        protected TextView tvDayDetail;
        @BindView(R.id.tvDetailChest)
        protected TextView tvDetailChest;
        @BindView(R.id.tvDetailBiceps)
        protected TextView tvDetailBiceps;
        @BindView(R.id.tvDetailShoulder)
        protected TextView tvDetailShoulder;
        @BindView(R.id.tvDetailTriceps)
        protected TextView tvDetailTriceps;


        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
