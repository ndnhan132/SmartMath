package com.example.pc.smartmath;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import Calculators.Balan;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtNumber;
    private Button btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8,
            btnNum9, btnNumCong, btnNumTru, btnNumNhan, btnNumChia, btnNumDu,
            btnNumMoNgoac, btnNumDongNgoac, btnNumDot, btnNumMu, btnNumCan,
            btnNumSin, btnNumCos, btnNumTan,
            btnNumLog, btnNumGiaithua, btnNumAns,
            btnNumXoa, btnNumXoahet,
            btnTinhtoan;
    private TextView mResult;
    private String bieuthuc;
    private double num;
    private Balan balan;
    private int mode;

    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        int bg = sharedPref.getInt("background_resource", 0);
        LinearLayout main= (LinearLayout)findViewById(R.id.llCal);
        main.setBackgroundColor(bg);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        getSupportActionBar().setTitle("Calculator");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        InitComponent();
        setWiget();
    }

    public void InitComponent() {
        balan = new Balan();
        num = 0;
        mode = 0;
        bieuthuc = "";
    }

    public void setWiget() {

        edtNumber = findViewById(R.id.edtNumber);

        btnNum0 = findViewById(R.id.btnNum0);
        btnNum1 = findViewById(R.id.btnNum1);
        btnNum2 = findViewById(R.id.btnNum2);
        btnNum3 = findViewById(R.id.btnNum3);
        btnNum4 = findViewById(R.id.btnNum4);
        btnNum5 = findViewById(R.id.btnNum5);
        btnNum6 = findViewById(R.id.btnNum6);
        btnNum7 = findViewById(R.id.btnNum7);
        btnNum8 = findViewById(R.id.btnNum8);
        btnNum9 = findViewById(R.id.btnNum9);

        btnNumCong = findViewById(R.id.btnNumCong);
        btnNumTru = findViewById(R.id.btnNumTru);
        btnNumNhan = findViewById(R.id.btnNumNhan);
        btnNumChia = findViewById(R.id.btnNumChia);
        btnNumDu = findViewById(R.id.btnNumDu);
        btnNumSin = findViewById(R.id.btnNumSin);
        btnNumCos = findViewById(R.id.btnNumCos);
        btnNumTan = findViewById(R.id.btnNumTan);
        btnNumAns = findViewById(R.id.btnNumAns);
        btnNumMu = findViewById(R.id.btnNumMu);
        btnNumCan = findViewById(R.id.btnNumCan);

        btnNumMoNgoac = findViewById(R.id.btnNumMoNgoac);
        btnNumDongNgoac = findViewById(R.id.btnNumDongNgoac);
        btnNumDot = findViewById(R.id.btnNumDot);

        btnNumLog = findViewById(R.id.btnNumlog);
        btnNumGiaithua = findViewById(R.id.btnNumGiaithua);
        btnNumXoa = findViewById(R.id.btnNumXoa);
        btnNumXoahet = findViewById(R.id.btnNumXoaHet);

        btnTinhtoan = findViewById(R.id.btnNumBang);
        mResult = findViewById(R.id.tv_result);

        btnNum0.setOnClickListener(this);
        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnNum4.setOnClickListener(this);
        btnNum5.setOnClickListener(this);
        btnNum6.setOnClickListener(this);
        btnNum7.setOnClickListener(this);
        btnNum8.setOnClickListener(this);
        btnNum9.setOnClickListener(this);
        btnTinhtoan.setOnClickListener(this);

        btnNumCong.setOnClickListener(this);
        btnNumTru.setOnClickListener(this);
        btnNumNhan.setOnClickListener(this);
        btnNumChia.setOnClickListener(this);
        btnNumDu.setOnClickListener(this);
        btnNumMoNgoac.setOnClickListener(this);
        btnNumDongNgoac.setOnClickListener(this);
        btnNumDot.setOnClickListener(this);
        btnNumLog.setOnClickListener(this);
        btnNumGiaithua.setOnClickListener(this);
        btnNumXoa.setOnClickListener(this);
        btnNumXoahet.setOnClickListener(this);
        btnNumSin.setOnClickListener(this);
        btnNumCos.setOnClickListener(this);
        btnNumTan.setOnClickListener(this);
        btnNumAns.setOnClickListener(this);
        btnNumMu.setOnClickListener(this);
        btnNumCan.setOnClickListener(this);

    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    public void onClick(View view) {
        bieuthuc = edtNumber.getText().toString();
        switch (view.getId()) {
            case R.id.edtNumber:
                //int currentMouse = edtNumber.getSelectionStart();//lay vi tri tro chuot
                hideKeyboard(view);
                break;
            case R.id.btnNum0:
                bieuthuc = bieuthuc + btnNum0.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNum1:
                bieuthuc = bieuthuc + btnNum1.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNum2:
                bieuthuc = bieuthuc + btnNum2.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNum3:
                bieuthuc = bieuthuc + btnNum3.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNum4:
                bieuthuc = bieuthuc + btnNum4.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNum5:
                bieuthuc = bieuthuc + btnNum5.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNum6:
                bieuthuc = bieuthuc + btnNum6.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNum7:
                bieuthuc = bieuthuc + btnNum7.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNum8:
                bieuthuc = bieuthuc + btnNum8.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNum9:
                bieuthuc = bieuthuc + btnNum9.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumCong:
                bieuthuc = bieuthuc + btnNumCong.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumTru:
                bieuthuc = bieuthuc + btnNumTru.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumNhan:
                bieuthuc = bieuthuc + btnNumNhan.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumChia:
                bieuthuc = bieuthuc + btnNumChia.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumDu:
                bieuthuc = bieuthuc + btnNumDu.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumMoNgoac:
                bieuthuc = bieuthuc + btnNumMoNgoac.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumDongNgoac:
                bieuthuc = bieuthuc + btnNumDongNgoac.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumDot:
                bieuthuc = bieuthuc + btnNumDot.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumMu:
                bieuthuc = bieuthuc + btnNumMu.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumCan:
                bieuthuc = bieuthuc + btnNumCan.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumlog:
                bieuthuc = bieuthuc + btnNumLog.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumGiaithua:
                bieuthuc = bieuthuc + btnNumGiaithua.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumXoa:
                if (bieuthuc.length() > 0) {
                    String s = bieuthuc.substring(0, bieuthuc.length() - 1);
                    bieuthuc = s;
                    edtNumber.setText(s);
                }
                break;
            case R.id.btnNumXoaHet:
                bieuthuc = "";
                mResult.setText("");
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumSin:
                bieuthuc = bieuthuc + btnNumSin.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumCos:
                bieuthuc = bieuthuc + btnNumCos.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumTan:
                bieuthuc = bieuthuc + btnNumTan.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumAns:
                bieuthuc = mResult.getText().toString();
                edtNumber.setText(bieuthuc);
                break;
            case R.id.btnNumBang:
                result();
                break;
        }
    }

    private void result() {
        try {
            bieuthuc = edtNumber.getText().toString();
            if (bieuthuc != "") {
                num = balan.valueMath(bieuthuc);
                String kq = Double.toString(num);
                mResult.setText(kq);
            }
        } catch (Exception e) {
        }


    }

}
