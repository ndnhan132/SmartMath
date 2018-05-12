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

public class TemperatureActivity extends AppCompatActivity {

    private EditText edtInput;
    private TextView tvOutput1,tvOutput2,tvOutput3,tvOutput4,tvOutput5,tvOutput6;
    private Spinner spnSelect;
    private double c, f,kelvin,rankine;
    private float input;

    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        int bg = sharedPref.getInt("background_resource", 0);
        LinearLayout main= (LinearLayout)findViewById(R.id.llTemp);
        main.setBackgroundColor(bg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        initWidget();
        getSupportActionBar().setTitle("Temperature");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<String> list= new ArrayList<>();
        list.add("C");
        list.add("F");
        list.add("Kelvin");
        list.add("Rankine");
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
        spnSelect=(Spinner)findViewById(R.id.spnSelect);
    }
    private void Convert(){
        try{
            input= Float.parseFloat(edtInput.getText().toString());
        }catch (Exception ex){
        }
        if(edtInput.getText().toString().equals("")){
            tvOutput1.setText(" ");
            tvOutput2.setText(" ");
            tvOutput3.setText(" ");
            tvOutput4.setText(" ");
        }else {
            String s= spnSelect.getSelectedItem().toString();
            double select =0;
            switch(s){
                case "C":
                    c=input;
                    select= c;
                    break;
                case "F":
                    select= (input-32)/1.8;
                    break;
                case "Kelvin":
                    select= input- 273.15;
                    break;
                case "Rankine":
                    select= (input-491.67)/1.8;
                    break;
            }
            tvOutput1.setText(select+" C");
            tvOutput2.setText((select*1.8)+32+" F");
            tvOutput3.setText((select+273.15)+" K");
            tvOutput4.setText((select*1.8)+491.67+" R");
        }
    }
}
