package com.example.finalpro;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Fragment_reservation extends Fragment {
    public Fragment_reservation(){

    }

    ArrayList<Reservations> reservations;
    ListView customReservcationListView;
    private static ReviewCustumAdapter customReservationAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_reservation,container,false);
        Log.e("TAG","onCreateViewReservation");
        TextView reservationResult=rootView.findViewById(R.id.reservationResult);
        reservationResult.setText(ChickenActivity.lastResult);

        return rootView;
    }


    class Reservations{
        private String time;
        private String name;
        private String peopleNum;

        public Reservations(String time, String name, String peopleNum) {
            this.time = time;
            this.name = name;
            this.peopleNum = peopleNum;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPeopleNum() {
            return peopleNum;
        }

        public void setPeopleNum(String peopleNum) {
            this.peopleNum = peopleNum;
        }
    }
}
