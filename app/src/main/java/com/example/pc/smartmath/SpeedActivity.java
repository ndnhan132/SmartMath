package com.example.pc.smartmath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SpeedActivity extends AppCompatActivity {

    private EditText edtInput;
    private TextView tvOutput1,tvOutput2,tvOutput3,tvOutput4,tvOutput5,tvOutput6;
    private Spinner spnSelect;
    private double ms, kmh,damh,yardh,foots,cms;
    private float input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);
        initWidget();
        getSupportActionBar().setTitle("Speed");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ms=1;
        kmh= 3.6*ms;
        damh= 2.237*ms;
        yardh= 3937.008*ms;
        foots=3.281*ms;
        cms= 100*ms;
        List<String>list= new ArrayList<>();
        list.add("M/s");
        list.add("Km/h");
        list.add("Dặm/h");
        list.add("Yard/h");
        list.add("Foot/s");
        list.add("Cm/s");
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
            tvOutput1.setText(input*select/ms+" m/s");
            tvOutput2.setText(input*select/kmh+" km/h");
            tvOutput3.setText(input*select/damh+" dặm/h");
            tvOutput4.setText(input*select/yardh+" yard/h");
            tvOutput5.setText(input*select/foots+" foot/s");
            tvOutput6.setText(input*select/cms+" cm/s");
        }
    }
    private double selected(){
        String s= spnSelect.getSelectedItem().toString();
        double select= 0;
        switch(s){
            case "M/s":
                select= ms;
                break;
            case "Km/h":
                select= kmh;
                break;
            case "Dặm/h":
                select= damh;
                break;
            case "Yard/h":
                select= yardh;
                break;
            case "Foot/s":
                select= foots;
                break;
            case "Cm/s":
                select= cms;
                break;
        }
        return select;
    }
}


