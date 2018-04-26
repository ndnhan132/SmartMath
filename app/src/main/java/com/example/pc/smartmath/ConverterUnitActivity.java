package com.example.pc.smartmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ConverterUnitActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imgbtnMoney,imgbtnSpeed,imgbtnTemperature, imgbtnWeight,imgbtnDistance, imgbtnAngle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_unit);

        initWidget();
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
