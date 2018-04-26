package com.example.pc.smartmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imgbtnCal,imgbtnCam,imgbtnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();


    }
    private void initWidget(){
        imgbtnCal=(ImageButton)findViewById(R.id.imgbtnCal);
        imgbtnCam=(ImageButton)findViewById(R.id.imgbtnCam);
        imgbtnConvert=(ImageButton)findViewById(R.id.imgbtnConvert);

        imgbtnCal.setOnClickListener(this);
        imgbtnConvert.setOnClickListener(this);
        imgbtnCam.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgbtnCal:
                startActivity(new Intent(getApplicationContext(), CalculatorActivity.class));
                break;
            case R.id.imgbtnCam:
                startActivity(new Intent(getApplicationContext(), CamActivity.class));
                break;
            case R.id.imgbtnConvert:
                startActivity(new Intent(getApplicationContext(), ConverterUnitActivity.class));
                break;
        }
    }
}