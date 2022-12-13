package com.example.finalpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    private int remainSeats;
    private EditText num1,num2,num3,num4,num5,num6,num7,num8,num9,num10;
    int remainingSeatsAfterCalc=0;
    private String[] menuList=new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        num3=findViewById(R.id.num3);
        num4=findViewById(R.id.num4);
        num5=findViewById(R.id.num5);
        num6=findViewById(R.id.num6);
        num7=findViewById(R.id.num7);
        num8=findViewById(R.id.num8);
        num9=findViewById(R.id.num9);
        num10=findViewById(R.id.num10);

        Intent intent=getIntent();
        remainSeats=intent.getIntExtra("remainSeats",-1);
        menuList[0]=intent.getStringExtra("num1");
        num1.setText(menuList[0]);
        menuList[1]=intent.getStringExtra("num2");
        num2.setText(menuList[1]);
        menuList[2]=intent.getStringExtra("num3");
        num3.setText(menuList[2]);
        menuList[3]=intent.getStringExtra("num4");
        num4.setText(menuList[3]);
        menuList[4]=intent.getStringExtra("num5");
        num5.setText(menuList[4]);
        menuList[5]=intent.getStringExtra("num6");
        num6.setText(menuList[5]);
        menuList[6]=intent.getStringExtra("num7");
        num7.setText(menuList[6]);
        menuList[7]=intent.getStringExtra("num8");
        num8.setText(menuList[7]);
        menuList[8]=intent.getStringExtra("num9");
        num9.setText(menuList[8]);
        menuList[9]=intent.getStringExtra("num10");
        num10.setText(menuList[9]);

        if(remainSeats!=-1){
            Toast.makeText(this.getApplicationContext(),"잔여좌석 : "+remainSeats,Toast.LENGTH_SHORT).show();
        }
    }

    public void checkRemainingSeats(){
        remainingSeatsAfterCalc=0;
        if(num1.getText().toString().matches("")){
            remainingSeatsAfterCalc++;
        }
        if(num2.getText().toString().matches("")){
            remainingSeatsAfterCalc++;
        }
        if(num3.getText().toString().matches("")){
            remainingSeatsAfterCalc++;
        }
        if(num4.getText().toString().matches("")){
            remainingSeatsAfterCalc++;
        }
        if(num5.getText().toString().matches("")){
            remainingSeatsAfterCalc++;
        }
        if(num6.getText().toString().matches("")){
            remainingSeatsAfterCalc++;
        }
        if(num7.getText().toString().matches("")){
            remainingSeatsAfterCalc++;
        }
        if(num8.getText().toString().matches("")){
            remainingSeatsAfterCalc++;
        }
        if(num9.getText().toString().matches("")){
            remainingSeatsAfterCalc++;
        }
        if(num10.getText().toString().matches("")){
            remainingSeatsAfterCalc++;
        }
    }


    public void mOnClick(View view){
        checkRemainingSeats();
        Intent data=new Intent();
        data.putExtra("result",remainingSeatsAfterCalc);
        data.putExtra("num1",num1.getText().toString());
        data.putExtra("num2",num2.getText().toString());
        data.putExtra("num3",num3.getText().toString());
        data.putExtra("num4",num4.getText().toString());
        data.putExtra("num5",num5.getText().toString());
        data.putExtra("num6",num6.getText().toString());
        data.putExtra("num7",num7.getText().toString());
        data.putExtra("num8",num8.getText().toString());
        data.putExtra("num9",num9.getText().toString());
        data.putExtra("num10",num10.getText().toString());
        setResult(RESULT_OK,data);
        finish();
    }

}