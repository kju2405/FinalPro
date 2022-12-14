package com.example.finalpro;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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
    private Button btn_menu,btn_review,btn_reservation,btn_waiting,btn_pos;
    private TextView remainSeatsNum;
    int remainSeats=10;
    private String[] menuList=new String[10];
    String reservationTime,reservationName,reservationNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken);

        btn_menu=findViewById(R.id.btn_menu);
        btn_review=findViewById(R.id.btn_review);
        btn_reservation=findViewById(R.id.btn_reservation);
        btn_waiting=findViewById(R.id.btn_waiting);
        btn_pos=findViewById(R.id.btn_pos);
        remainSeatsNum=(TextView)findViewById(R.id.remainingSeats);
        remainSeatsNum.setText("잔여좌석 : "+remainSeats+"좌석");
        Log.e("TAG","onCreate()");



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

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG","onStart");
        if(remainSeats==0){
            btn_waiting.setEnabled(true);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG","onResume");
    }

    public void updateResult(){
        TextView textResult=(TextView) findViewById(R.id.reservationResult);
        String lastResult=textResult.getText().toString();
        lastResult=lastResult+reservationTime+" | "+reservationName+" | "+reservationNum+"명\n";
        textResult.setText(lastResult);
    }


    public void mOnClick(View view){
        switch (view.getId()){
            case R.id.btn_pos:
                Intent intent=new Intent(this,SubActivity.class);
                intent.putExtra("remainSeats",remainSeats);
                intent.putExtra("num1",menuList[0]);
                intent.putExtra("num2",menuList[1]);
                intent.putExtra("num3",menuList[2]);
                intent.putExtra("num4",menuList[3]);
                intent.putExtra("num5",menuList[4]);
                intent.putExtra("num6",menuList[5]);
                intent.putExtra("num7",menuList[6]);
                intent.putExtra("num8",menuList[7]);
                intent.putExtra("num9",menuList[8]);
                intent.putExtra("num10",menuList[9]);
                startActivityForResult(intent,0);
                break;
            case R.id.btn_makeReservation:
                AlertDialog.Builder builder;
                builder=new AlertDialog.Builder(this);
                LayoutInflater inflater=getLayoutInflater();
                View layout=inflater.inflate(R.layout.dialog_reservation,null);
                builder.setView(layout);

                final EditText mEditTime=(EditText) layout.findViewById(R.id.editTime);
                final EditText mEditName=(EditText) layout.findViewById(R.id.editName);
                final EditText mEditPeopleNum=(EditText) layout.findViewById(R.id.editPeopleNum);

                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        reservationTime=mEditTime.getText().toString();
                        reservationName=mEditName.getText().toString();
                        reservationNum=mEditPeopleNum.getText().toString();
                        updateResult();
                    }
                });

                builder.setNegativeButton(android.R.string.cancel,null);

                builder.create().show();
                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode==0 && resultCode==RESULT_OK){
            remainSeats=data.getIntExtra("result",0);
            remainSeatsNum.setText("잔여좌석 : "+remainSeats+"좌석");
            menuList[0]=data.getStringExtra("num1");
            menuList[1]=data.getStringExtra("num2");
            menuList[2]=data.getStringExtra("num3");
            menuList[3]=data.getStringExtra("num4");
            menuList[4]=data.getStringExtra("num5");
            menuList[5]=data.getStringExtra("num6");
            menuList[6]=data.getStringExtra("num7");
            menuList[7]=data.getStringExtra("num8");
            menuList[8]=data.getStringExtra("num9");
            menuList[9]=data.getStringExtra("num10");
            Toast.makeText(this.getApplicationContext(),"잔여좌석 : "+remainSeats,Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode,resultCode,data);
    }


}