package com.stepon.gymapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stepon.gymapp.R;
import com.stepon.gymapp.activity.WorkDetailActivity;
import com.stepon.gymapp.model.ModelDayWork;
import com.stepon.gymapp.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDayWork extends RecyclerView.Adapter<AdapterDayWork.DayViewHolder> {
    private Context tContext;
    private List<ModelDayWork> tModelsDayWork;

    public AdapterDayWork(Context tContext, List<ModelDayWork> tModelsDayWork) {
        this.tContext = tContext;
        this.tModelsDayWork = tModelsDayWork;
    }

    @NonNull
    @Override
    public DayViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_day_work_item, viewGroup, false);
        return new DayViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull DayViewHolder dayViewHolder, int i) {

        final ModelDayWork tModelDarWork = tModelsDayWork.get(i);

        final String  strWorkoutVideo = Constant.VID_URL+tModelDarWork.getWorkoutVideo();
        dayViewHolder.tvDayWorkTitle.setText("\u25CF \t"+tModelDarWork.getWorkoutTitle());
        dayViewHolder.tvDayWorkTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tIntent = new Intent(tContext, WorkDetailActivity.class);
                tIntent.putExtra("ModelDetail",tModelDarWork);
                tContext.startActivity(tIntent);
            }
        });
        dayViewHolder.tvDayWorkVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chestIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(strWorkoutVideo));
                tContext.startActivity(chestIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tModelsDayWork.size();
    }
    public class DayViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvDayWorkTitle)
        protected TextView tvDayWorkTitle;
        @BindView(R.id.tvDayWorkVideo)
        protected TextView tvDayWorkVideo;

        public DayViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
