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

public class WeightActivity extends AppCompatActivity {

    private EditText edtInput;
    private TextView tvOutput1,tvOutput2,tvOutput3,tvOutput4,tvOutput5,tvOutput6;
    private Spinner spnSelect;
    private double g, kg,pound,cara,ta,tan;
    private float input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        initWidget();
        getSupportActionBar().setTitle("Weight");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        g=1;
        kg=1000*g;
        ta=100000*g;
        tan=1000000*g;
        cara=g/5;
        pound= 453.59237*g;

        List<String>list= new ArrayList<>();
        list.add("G");
        list.add("Kg");
        list.add("Pound");
        list.add("Cara");
        list.add("Tạ");
        list.add("Tấn");
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
            tvOutput1.setText(input*select/g+" G");
            tvOutput2.setText(input*select/kg+" Kg");
            tvOutput3.setText(input*select/pound+" Pound");
            tvOutput4.setText(input*select/cara+" Cara");
            tvOutput5.setText(input*select/ta+" Tạ");
            tvOutput6.setText(input*select/tan+" Tấn");
        }
    }
    private double selected(){
        String s= spnSelect.getSelectedItem().toString();
        double select= 0;
        switch(s){
            case "G":
                select= g;
                break;
            case "Kg":
                select= kg;
                break;
            case "Cara":
                select= cara;
                break;
            case "Pound":
                select= pound;
                break;
            case "Tạ":
                select= ta;
                break;
            case "Tấn":
                select= tan;
                break;
        }
        return select;
    }
}
