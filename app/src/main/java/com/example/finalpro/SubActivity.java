package com.example.finalpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    private int remainSeats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent=getIntent();
        remainSeats=intent.getIntExtra("remainSeats",-1);
        if(remainSeats!=-1){
            Toast.makeText(this.getApplicationContext(),"잔여좌석 : "+remainSeats,Toast.LENGTH_SHORT).show();
        }
    }

    public void mOnClick(View view){
        Intent data=new Intent();
        data.putExtra("result",remainSeats);
        setResult(RESULT_OK,data);
        finish();
    }

}