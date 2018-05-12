package com.example.pc.smartmath;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SettingActivity extends AppCompatActivity {
    private Spinner spnLang, spnBg, spnSize;

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        int bg = sharedPref.getInt("background_resource", 0);
        LinearLayout main= (LinearLayout)findViewById(R.id.llSetting);
        main.setBackgroundColor(bg);

        SharedPreferences sharedSize = getSharedPreferences("my_prefs_size", Context.MODE_PRIVATE);
        int k = sharedSize.getInt("icon_size",0);
        switch (k){
            case 250:
                spnSize.setSelection(0);
                break;
            case 175:
                spnSize.setSelection(1);
                break;
            case 100:
                spnSize.setSelection(2);
                break;
        }
        SharedPreferences shared_Pos_bg= getSharedPreferences("my_prefs_bg",Context.MODE_PRIVATE);
        int pos=shared_Pos_bg.getInt("this_bg",0);
        switch (pos){
            case 0:
                spnBg.setSelection(0);
                break;
            case 1:
                spnBg.setSelection(1);
                break;
            case 2:
                spnBg.setSelection(2);
                break;
            case 3:
                spnBg.setSelection(3);
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        spnBg  = (Spinner)findViewById(R.id.spnBg);
        spnLang= (Spinner)findViewById(R.id.spnLang);
        spnSize  = (Spinner)findViewById(R.id.spnSize);

        List<String> lang_list= new ArrayList<>();
        lang_list.add("Tiếng Việt");
        lang_list.add("English");
        ArrayAdapter<String> lang_adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lang_list);
        lang_adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnLang.setAdapter(lang_adapter);

        List<String> bg_list= new ArrayList<>();
        bg_list.add("Trắng");
        bg_list.add("Xanh lá");
        bg_list.add("Vàng");
        bg_list.add("Xám");
        ArrayAdapter<String> bg_adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,bg_list);
        bg_adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnBg.setAdapter(bg_adapter);


        List<String> size_list= new ArrayList<>();
        size_list.add("Large");
        size_list.add("Medium");
        size_list.add("Small");
        ArrayAdapter<String> size_adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,size_list);
        size_adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnSize.setAdapter(size_adapter);



        spnLang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spnBg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s= spnBg.getSelectedItem().toString();
                SharedPreferences sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                int pos=0;
                switch (s){
                    case "Trắng":
                        pos=0;
                        editor.putInt("background_resource", ContextCompat.getColor(getApplicationContext(), R.color.white));
                        editor.commit();
                        break;
                    case "Xanh lá":
                        pos=1;
                        editor.putInt("background_resource", ContextCompat.getColor(getApplicationContext(), R.color.green));
                        editor.commit();
                        break;
                    case "Vàng":
                        pos=2;
                        editor.putInt("background_resource", ContextCompat.getColor(getApplicationContext(), R.color.yellow));
                        editor.commit();
                        break;
                    case "Xám":
                        pos=3;
                        editor.putInt("background_resource", ContextCompat.getColor(getApplicationContext(), R.color.gray));
                        editor.commit();
                        break;
                }
                SharedPreferences shared_Pos_bg= getSharedPreferences("my_prefs_bg",Context.MODE_PRIVATE);
                SharedPreferences.Editor bg_editor= shared_Pos_bg.edit();
                bg_editor.putInt("this_bg", pos);
                bg_editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spnSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences sharedSize = getSharedPreferences("my_prefs_size", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor_size = sharedSize.edit();
                switch (spnSize.getSelectedItem().toString()){
                    case "Large":
                        editor_size.putInt("icon_size",250);
                        editor_size.commit();
                        break;
                    case "Medium":
                        editor_size.putInt("icon_size",175);
                        editor_size.commit();
                        break;
                    case "Small":
                        editor_size.putInt("icon_size",100);
                        editor_size.commit();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
