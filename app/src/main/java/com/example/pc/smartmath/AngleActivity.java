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

public class AngleActivity extends AppCompatActivity {

    private EditText edtInput;
    private TextView tvOutput1,tvOutput2,tvOutput3,tvOutput4,tvOutput5,tvOutput6;
    private Spinner spnSelect;
    private float m, cm,mm,km,nm,um;
    private float input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angle);
        initWidget();

        m=1;
        cm=m/100;
        mm=m/1000;
        km=m*1000;
        nm=m/1000000000;
        um=m/1000000;
        List<String> list= new ArrayList<>();
        list.add("m");
        list.add("cm");
        list.add("mm");
        list.add("km");
        list.add("nm");
        list.add("µm");
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
        float select= selected();
        tvOutput1.setText(input*select/m+" m");
        tvOutput2.setText(input*select/cm+" cm");
        tvOutput3.setText(input*select/mm+" mm");
        tvOutput4.setText(input*select/km+" km");
        tvOutput5.setText(input*select/nm+" nm");
        tvOutput6.setText(input*select/um+" µm");
    }
    private float selected(){
        String s= spnSelect.getSelectedItem().toString();
        float select= 0;
        switch(s){
            case "m":
                select= m;
                break;
            case "mm":
                select= mm;
                break;
            case "cm":
                select= cm;
                break;
            case "km":
                select= km;
                break;
            case "nm":
                select= nm;
                break;
            case "um":
                select= um;
                break;
        }
        return select;
    }
}
