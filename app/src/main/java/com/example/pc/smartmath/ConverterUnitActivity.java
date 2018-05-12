package com.example.pc.smartmath;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class ConverterUnitActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imgbtnMoney,imgbtnSpeed,imgbtnTemperature, imgbtnWeight,imgbtnDistance, imgbtnAngle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_unit);

        initWidget();
        getSupportActionBar().setTitle("ConverterUnit");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        int bg = sharedPref.getInt("background_resource", 0);
        LinearLayout main= (LinearLayout)findViewById(R.id.llCv);
        main.setBackgroundColor(bg);

        SharedPreferences sharedSize = getSharedPreferences("my_prefs_size", Context.MODE_PRIVATE);
        int k = sharedSize.getInt("icon_size",0);
        imgbtnMoney.getLayoutParams().width=k;
        imgbtnMoney.getLayoutParams().height=k;
        imgbtnSpeed.getLayoutParams().width=k;
        imgbtnSpeed.getLayoutParams().height=k;
        imgbtnAngle.getLayoutParams().width=k;
        imgbtnAngle.getLayoutParams().height=k;
        imgbtnDistance.getLayoutParams().width=k;
        imgbtnDistance.getLayoutParams().height=k;
        imgbtnTemperature.getLayoutParams().width=k;
        imgbtnTemperature.getLayoutParams().height=k;
        imgbtnWeight.getLayoutParams().width=k;
        imgbtnWeight.getLayoutParams().height=k;
    }

    private void initWidget(){
        imgbtnMoney= (ImageButton)findViewById(R.id.imgbtnMoney);
        imgbtnSpeed= (ImageButton)findViewById(R.id.imgbtnSpeed);
        imgbtnAngle= (ImageButton)findViewById(R.id.imgbtnAngle);
        imgbtnDistance= (ImageButton)findViewById(R.id.imgbtnDistance);
        imgbtnTemperature= (ImageButton)findViewById(R.id.imgbtnTemperature);
        imgbtnWeight= (ImageButton)findViewById(R.id.imgbtnWeight);

        imgbtnMoney.setOnClickListener(this);
        imgbtnWeight.setOnClickListener(this);
        imgbtnDistance.setOnClickListener(this);
        imgbtnTemperature.setOnClickListener(this);
        imgbtnAngle.setOnClickListener(this);
        imgbtnSpeed.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgbtnMoney:
                startActivity(new Intent(getApplicationContext(), CurrencyActivity.class));
                break;
            case R.id.imgbtnSpeed:
                startActivity(new Intent(getApplicationContext(), SpeedActivity.class));
                break;
            case R.id.imgbtnDistance:
                startActivity(new Intent(getApplicationContext(), DistanceActivity.class));
                break;
            case R.id.imgbtnTemperature:
                startActivity(new Intent(getApplicationContext(), TemperatureActivity.class));
                break;
            case R.id.imgbtnWeight:
                startActivity(new Intent(getApplicationContext(), WeightActivity.class));
                break;
            case R.id.imgbtnAngle:
                startActivity(new Intent(getApplicationContext(),AngleActivity.class));
                break;
        }
    }
}
