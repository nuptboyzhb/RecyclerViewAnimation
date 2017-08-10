package com.github.nuptboyzhb.recyclerviewanimation.grid;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.nuptboyzhb.recyclerviewanimation.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @version Created by haibozheng on 2017/8/9.
 * @Author Zheng Haibo
 * @Blog github.com/nuptboyzhb
 * @Company Alibaba Group
 * @Description RecyclerViewAnimation
 */

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.ViewHolder> {

    private List<Items> mDataSet = new ArrayList<>();


    public void setDataSet(List<Items> mDataSet) {
        this.mDataSet = mDataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(mDataSet.get(position).name);
        holder.imageView.setImageResource(mDataSet.get(position).resId);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_view);
            textView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }

    public static class Items implements Serializable {
        public String name;
        public int resId;

        public Items(String name, int resId) {
            this.name = name;
            this.resId = resId;
        }
    }

}