package com.stepon.gymapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stepon.gymapp.R;
import com.stepon.gymapp.fragment.DietDetailFragment;
import com.stepon.gymapp.model.ModelDiet;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDietList extends RecyclerView.Adapter<AdapterDietList.DietViewHolder> {

    private Context tContext;
    private List<ModelDiet> tModels;
    private FragmentManager tFragmentManager;

    public AdapterDietList(Context tContext, List<ModelDiet> tModels, FragmentManager tFragmentManager) {
        this.tContext = tContext;
        this.tModels = tModels;
        this.tFragmentManager = tFragmentManager;
    }
    @NonNull
    @Override
    public DietViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_diet_item, viewGroup, false);
        return new DietViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull DietViewHolder dietViewHolder, int i) {
        final ModelDiet tModel = tModels.get(i);
        dietViewHolder.tvDietList.setText(tModel.getDietTitle());
        dietViewHolder.llDietList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tFragmentManager.beginTransaction().replace(R.id.diet_container, DietDetailFragment.newInstance(tModel.getDietTitle(), tModel.getDetail())).addToBackStack(null).commit();
            }
        });
    }
    @Override
    public int getItemCount() {
        return tModels.size();
    }

    public class DietViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvDietList)
        protected TextView tvDietList;
        @BindView(R.id.llDietList)
        protected LinearLayout llDietList;

        public DietViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
