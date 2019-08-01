package com.stepon.gymapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stepon.gymapp.R;
import com.stepon.gymapp.activity.DetailActivity;
import com.stepon.gymapp.model.ModelCategory;
import com.stepon.gymapp.model.ModelWeek;
import com.stepon.gymapp.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterWeek extends RecyclerView.Adapter<AdapterWeek.CategoryViewHolder> {

    private Context tContext;
    private List<ModelWeek> tModelsWeek;

    public AdapterWeek(Context tContext, List<ModelWeek> tModelsWeek) {
        this.tContext = tContext;
        this.tModelsWeek = tModelsWeek;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frag_main_item, viewGroup, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        ModelWeek tModelWeek = tModelsWeek.get(i);
        final String strWeek = tModelWeek.getWeek();
        final String strWeekId = tModelWeek.getId();
        categoryViewHolder.tvWeek.setText(strWeek);
        categoryViewHolder.llFragMainItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tIntent = new Intent(tContext, DetailActivity.class);
                tIntent.putExtra(Constant.WEEK_ID, strWeekId);
                tContext.startActivity(tIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tModelsWeek.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvWeek)
        protected TextView tvWeek;
        @BindView(R.id.llFragMainItem)
        protected LinearLayout llFragMainItem;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
