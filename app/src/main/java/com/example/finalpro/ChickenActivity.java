package com.example.finalpro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChickenActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<ChickenRecyclerViewItem> mList= new ArrayList<ChickenRecyclerViewItem>();;
    private ChickenAdapter mRecyclerViewAdapter;
    int[] chickenImages = {R.drawable.kh_chicken, R.drawable.chicken_inner, R.drawable.chicken3,R.drawable.chicken4};
    private Button btn_menu,btn_review,btn_reservation,btn_waiting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken);

        btn_menu=findViewById(R.id.btn_menu);
        btn_review=findViewById(R.id.btn_review);
        btn_reservation=findViewById(R.id.btn_reservation);
        btn_waiting=findViewById(R.id.btn_waiting);


        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                Fragment_menu fragment_menu=new Fragment_menu();
                transaction.replace(R.id.frame,fragment_menu);
                transaction.commit();

            }
        });

        btn_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                Fragment_review fragment_review=new Fragment_review();
                transaction.replace(R.id.frame,fragment_review);
                transaction.commit();
            }
        });

        btn_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                Fragment_reservation fragment_reservation=new Fragment_reservation();
                transaction.replace(R.id.frame,fragment_reservation);
                transaction.commit();
            }
        });

        btn_waiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                Fragment_waiting fragment_waiting=new Fragment_waiting();
                transaction.replace(R.id.frame,fragment_waiting);
                transaction.commit();
            }
        });

        mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
//        mList = new ArrayList<ChickenRecyclerViewItem>();

//        List<String> imgPath= Arrays.asList("R.drawable.kh_chicken","R.drawable.chicken_inner","R.drawable.chicken3");

        for(int i=0;i<chickenImages.length;i++){
            mList.add(new ChickenRecyclerViewItem(chickenImages[i],"Image "+(i+1)));
        }
        mRecyclerViewAdapter = new ChickenAdapter(mList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));


    }


}