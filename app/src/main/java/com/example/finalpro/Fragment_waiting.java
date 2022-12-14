package com.example.finalpro;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_waiting extends Fragment {
    public Fragment_waiting(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_waiting,container,false);
        Log.e("TAG","onCreateViewWaiting");
        TextView waitingResult=rootView.findViewById(R.id.waitingResult);
        waitingResult.setText(ChickenActivity.lastResultWaiting);

        return rootView;
    }
}
