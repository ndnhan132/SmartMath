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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DistanceActivity extends AppCompatActivity {

    private EditText edtInput;
    private TextView tvOutput1,tvOutput2,tvOutput3,tvOutput4,tvOutput5,tvOutput6;
    private Spinner spnSelect;
    private double m,mm,km,dam, foot, inch;
    private float input;

    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        int bg = sharedPref.getInt("background_resource", 0);
        LinearLayout main= (LinearLayout)findViewById(R.id.llDis);
        main.setBackgroundColor(bg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);
        initWidget();
        getSupportActionBar().setTitle("Distance");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        m=1;
        mm=m/1000;
        km=m*1000;
        dam= m* 1609.344;
        foot= m*0.3048;
        inch= m*0.0254;
        List<String>list= new ArrayList<>();
        list.add("m");
        list.add("mm");
        list.add("km");
        list.add("Dặm");
        list.add("Foot");
        list.add("Inch");
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
            tvOutput6.setText(" ");
        }else {
            double select= selected();
            tvOutput1.setText(input*select/m+" m");
            tvOutput2.setText(input*select/mm+" mm");
            tvOutput3.setText(input*select/km+" km");
            tvOutput4.setText(input*select/dam+" Dặm");
            tvOutput5.setText(input*select/foot+" foot");
            tvOutput6.setText(input*select/inch+" inch");
        }
    }
    private double selected(){
        String s= spnSelect.getSelectedItem().toString();
        double select= 0;
        switch(s){
            case "m":
                select= m;
                break;
            case "mm":
                select= mm;
                break;
            case "Dặm":
                select= dam;
                break;
            case "km":
                select= km;
                break;
            case "Foot":
                select= foot;
                break;
            case "Inch":
                select= inch;
                break;
        }
        return select;
    }
}
