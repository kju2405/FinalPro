package com.example.finalpro;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Fragment_review extends Fragment {
    public Fragment_review(){

    }

    ArrayList<Review> reviews;
    ListView customReviewListView;
    private static ReviewCustumAdapter customReviewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_review,container,false);

        Log.e("TAG","onCreateViewReview");

        reviews=new ArrayList<>();
        reviews.add(new Review("★★★★","맛있어요~~","(kju****)"));
        reviews.add(new Review("★★★★","축구보면서 잘 먹었어요!","(woong****)"));
        reviews.add(new Review("★★","식어서 왔어요","(lala***)"));
        reviews.add(new Review("★","별로에요","(jae***)"));
        reviews.add(new Review("★★★","그럭저럭","(kim***)"));
        reviews.add(new Review("★★★★","좋아요","(suk****)"));
        reviews.add(new Review("★★★★","자리가 많아요","(yoon****)"));
        reviews.add(new Review("★★★★","바삭바삭해요","(joon****)"));
        reviews.add(new Review("★★★★","굿굿~","(gun****)"));
        reviews.add(new Review("★★","소스맛이 너무 세요","(ryu****)"));

        customReviewListView = (ListView) rootView.findViewById(R.id.listReview);
        customReviewAdapter = new ReviewCustumAdapter(getContext(),reviews);
        customReviewListView.setAdapter(customReviewAdapter);
        return rootView;
    }

    class Review{
        private String star;
        private String review;
        private String userId;

        public Review(String star, String review, String userId) {
            this.star = star;
            this.review = review;
            this.userId = userId;
        }

        public String getStar() {
            return star;
        }

        public void setStar(String star) {
            this.star = star;
        }

        public String getReview() {
            return review;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
