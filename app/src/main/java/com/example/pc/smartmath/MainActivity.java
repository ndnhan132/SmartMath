package com.example.pc.smartmath;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imgbtnCal,imgbtnCam,imgbtnConvert, imgbtnList, imgbtnSetting,imgbtnTeam;

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
        imgbtnList= (ImageButton)findViewById(R.id.imgbtnList);
        imgbtnSetting=(ImageButton)findViewById(R.id.imgbtnSetting);
        imgbtnTeam=(ImageButton) findViewById(R.id.imgbtnTeam);

        imgbtnCal.setOnClickListener(this);
        imgbtnConvert.setOnClickListener(this);
        imgbtnCam.setOnClickListener(this);
        imgbtnTeam.setOnClickListener(this);
        imgbtnTeam.setOnClickListener(this);
        imgbtnList.setOnClickListener(this);
        imgbtnSetting.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        int bg = sharedPref.getInt("background_resource", 0);
        if (bg==0){
            bg= ContextCompat.getColor(getApplicationContext(), R.color.white);
        }
        LinearLayout main= (LinearLayout)findViewById(R.id.llMain);
        main.setBackgroundColor(bg);

        SharedPreferences sharedSize = getSharedPreferences("my_prefs_size", Context.MODE_PRIVATE);
        int k = sharedSize.getInt("icon_size",0);
        if(k==0){
            k=175;
        }
        imgbtnCal.getLayoutParams().width=k;
        imgbtnCal.getLayoutParams().height=k;
        imgbtnConvert.getLayoutParams().width=k;
        imgbtnConvert.getLayoutParams().height=k;
        imgbtnCam.getLayoutParams().width=k;
        imgbtnCam.getLayoutParams().height=k;
        imgbtnList.getLayoutParams().width=k;
        imgbtnList.getLayoutParams().height=k;
        imgbtnSetting.getLayoutParams().width=k;
        imgbtnSetting.getLayoutParams().height=k;
        imgbtnTeam.getLayoutParams().width=k;
        imgbtnTeam.getLayoutParams().height=k;
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
            case R.id.imgbtnList:
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
                break;
            case R.id.imgbtnSetting:
                startActivity(new Intent(getApplicationContext(), SettingActivity.class));
                break;
            case R.id.imgbtnTeam:
                startActivity(new Intent(getApplicationContext(), TeamActivity.class));
                break;
        }
    }
}
