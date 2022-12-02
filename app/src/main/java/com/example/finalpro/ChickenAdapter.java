package com.example.finalpro;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChickenAdapter extends RecyclerView.Adapter<ChickenAdapter.ViewHolder>{


    private ArrayList<ChickenRecyclerViewItem> mList;

    public ChickenAdapter(ArrayList<ChickenRecyclerViewItem> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ChickenAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chicken_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChickenAdapter.ViewHolder holder, int position) {

        ChickenRecyclerViewItem item = mList.get(position);


//        holder.imgView_item.setImageResource(R.drawable.kh_chicken);
        holder.imgView_item.setImageResource(item.getmImgName());
        holder.txt_main.setText(item.getmMainText());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView_item;
        TextView txt_main;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView_item = (ImageView) itemView.findViewById(R.id.imgView_item);
            txt_main = (TextView) itemView.findViewById(R.id.txt_main);

            imgView_item.setBackground(new ShapeDrawable(new RectShape()));
            imgView_item.setClipToOutline(true);
        }
    }
}
