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

public class CurrencyActivity extends AppCompatActivity {

    private EditText edtInput;
    private TextView tvOutput1,tvOutput2,tvOutput3,tvOutput4,tvOutput5,tvOutput6;
    private Spinner spnSelect;
    private float vnd, usd,eur,gbp,cny,jpy;
    private float input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        initWidget();
        getSupportActionBar().setTitle("Money");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vnd=1;
        usd=vnd*22800;
        eur=vnd*27800;
        gbp=vnd*31800;
        cny=vnd*3600;
        jpy=vnd*17;
        List<String> list= new ArrayList<>();
        list.add("Vnd");
        list.add("Dolla");
        list.add("Uero");
        list.add("Bảng Anh");
        list.add("Ndt");
        list.add("Yên");
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
            float select= selected();
            tvOutput1.setText(input*select/vnd+" Vnd");
            tvOutput2.setText(input*select/usd+" Dolla");
            tvOutput3.setText(input*select/eur+" Uero");
            tvOutput4.setText(input*select/gbp+" Bảng Anh");
            tvOutput5.setText(input*select/cny+" Ndt");
            tvOutput6.setText(input*select/jpy+" Yên");
        }
    }
    private float selected(){
        String s= spnSelect.getSelectedItem().toString();
        float select= 0;
        switch(s){
            case "Vnd":
                select= vnd;
                break;
            case "Dolla":
                select= usd;
                break;
            case "Uero":
                select= eur;
                break;
            case "Bảng Anh":
                select= gbp;
                break;
            case "Ndt":
                select= cny;
                break;
            case "Yên":
                select= jpy;
                break;
        }
        return select;
    }
}
