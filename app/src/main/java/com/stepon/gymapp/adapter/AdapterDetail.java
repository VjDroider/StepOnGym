package com.stepon.gymapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stepon.gymapp.R;
import com.stepon.gymapp.activity.WorkDetailActivity;
import com.stepon.gymapp.model.login.ModelDetail;
import com.stepon.gymapp.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDetail extends RecyclerView.Adapter<AdapterDetail.DetailViewHolder> {

    private Context tContext;
    private FragmentManager tFragmentManager;
    private List<ModelDetail> tModelsDetail;

    public AdapterDetail(Context tContext, List<ModelDetail> tModelsDetail, FragmentManager tFragmentManager) {
        this.tContext = tContext;
        this.tModelsDetail = tModelsDetail;
        this.tFragmentManager = tFragmentManager;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detail_item, viewGroup, false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder detailViewHolder, int i) {

        final ModelDetail tModelDetail = tModelsDetail.get(i);
        String strWeek = tModelDetail.getDay();
        detailViewHolder.tvDayDetail.setText(strWeek);

      final String  strWorkoutVideo = Constant.VID_URL+tModelDetail.getWorkoutVideo();
        detailViewHolder.tvDetailChestDetail.setText(tModelDetail.getWorkoutTitle());
        detailViewHolder.tvDetailChestDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tIntent = new Intent(tContext, WorkDetailActivity.class);
                tIntent.putExtra("ModelDetail",tModelDetail);
                tContext.startActivity(tIntent);
            }
        });
        detailViewHolder.tvDetailChest .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chestIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(strWorkoutVideo));
                tContext.startActivity(chestIntent);
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
        @BindView(R.id.tvDetailChestDetail)
        protected TextView tvDetailChestDetail;


        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
