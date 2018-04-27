package com.example.pc.smartmath;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity {
    private Spinner spnLang, spnBg, spnSize;
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
    }
}
