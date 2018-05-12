package com.example.pc.smartmath;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AngleActivity extends AppCompatActivity {

    private EditText edtInput;
    private TextView tvOutput1,tvOutput2,tvOutput3,tvOutput4,tvOutput5,tvOutput6;
    private Spinner spnSelect;
    private double mdo, giay, phut, rad, grad;
    private float input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angle);
        initWidget();
        getSupportActionBar().setTitle("Angle");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mdo=1;
        giay= mdo/3600;
        phut= mdo/60;
        rad= mdo*57.296;
        grad=mdo*0.9;

        List<String>list= new ArrayList<>();
        list.add("Độ");
        list.add("Giây");
        list.add("Phút");
        list.add("Radian");
        list.add("Grad");
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnSelect.setAdapter(adapter);

        spnSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Convert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        edtInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Convert();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        int bg = sharedPref.getInt("background_resource", 0);
        LinearLayout main= (LinearLayout)findViewById(R.id.llAngle);
        main.setBackgroundColor(bg);
    }

    private void initWidget(){
        edtInput= (EditText)findViewById(R.id.edtInput);
        tvOutput1= (TextView) findViewById(R.id.tvOutput1);
        tvOutput2= (TextView) findViewById(R.id.tvOutput2);
        tvOutput3= (TextView) findViewById(R.id.tvOutput3);
        tvOutput4= (TextView) findViewById(R.id.tvOutput4);
        tvOutput5= (TextView) findViewById(R.id.tvOutput5);
        tvOutput6= (TextView) findViewById(R.id.tvOutput6);
        spnSelect=(Spinner)findViewById(R.id.spnSelect);
    }
    private void Convert(){
        try{
            input= Float.parseFloat(edtInput.getText().toString());
        }catch (Exception ex){
        }
        if (edtInput.getText().toString().equals("")){
            tvOutput1.setText(" ");
            tvOutput2.setText(" ");
            tvOutput3.setText(" ");
            tvOutput4.setText(" ");
            tvOutput5.setText(" ");
        }else {
            double select= selected();
            tvOutput1.setText(input*select/mdo+" Độ");
            tvOutput2.setText(input*select/giay+" Giây");
            tvOutput3.setText(input*select/phut+" Phút");
            tvOutput4.setText(input*select/rad+" Radian");
            tvOutput5.setText(input*select/grad+" Grad");
        }
    }
    private double selected(){
        String s= spnSelect.getSelectedItem().toString();
        double select= 0;
        switch(s){
            case "Độ":
                select= mdo;
                break;
            case "Giây":
                select= giay;
                break;
            case "Phút":
                select= phut;
                break;
            case "Radian":
                select= rad;
                break;
            case "Grad":
                select= grad;
                break;
        }
        return select;
    }
}