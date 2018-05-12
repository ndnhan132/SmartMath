package com.example.pc.smartmath;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class ListActivity extends AppCompatActivity {
    private TextView tvView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().setTitle("Document");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvView=(TextView)findViewById(R.id.tvView);
        readData();
    }

    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        int bg = sharedPref.getInt("background_resource", 0);
        LinearLayout main= (LinearLayout)findViewById(R.id.llList);
        main.setBackgroundColor(bg);
    }
    private void readData(){
//        String data;
//        InputStream inputStream =  getResources().openRawResource(R.drawable.document);
//        InputStreamReader inreader=new InputStreamReader(inputStream);
//        BufferedReader bufreader=new BufferedReader(inreader);
//        StringBuilder builder=new StringBuilder();
//        if(in!=null)
//        {
//            try
//            {
//                while((data=bufreader.readLine())!=null)
//                {
//                    builder.append(data);
//                    builder.append("\n");
//                }
//                inputStream.close();
//                tvView.setText(builder.toString());
//            }
//            catch(IOException ex){
//                Log.e("ERROR", ex.getMessage());
//            }
//        }
    }
}

