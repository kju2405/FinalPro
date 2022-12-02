package com.example.finalpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ReviewCustumAdapter extends ArrayAdapter implements AdapterView.OnItemClickListener{

    private Context context;
    private List list;

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
    }

    class ViewHolder {
        public TextView tv_star;
        public TextView tv_review;
        public TextView tv_userId;
    }

    public ReviewCustumAdapter(Context context, ArrayList list){
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ReviewCustumAdapter.ViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.review_item, parent, false);
        }

        viewHolder = new ReviewCustumAdapter.ViewHolder();
        viewHolder.tv_star=(TextView) convertView.findViewById(R.id.reviewStar);
        viewHolder.tv_review = (TextView) convertView.findViewById(R.id.reviewSay);
        viewHolder.tv_userId=(TextView) convertView.findViewById(R.id.reviewUserId);

        final Fragment_review.Review review = (Fragment_review.Review) list.get(position);
        viewHolder.tv_star.setText(review.getStar());
        viewHolder.tv_review.setText(review.getReview());
        viewHolder.tv_userId.setText(review.getUserId());

        return convertView;
    }
}
