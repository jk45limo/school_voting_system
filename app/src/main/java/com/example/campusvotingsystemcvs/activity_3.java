package com.example.campusvotingsystemcvs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class activity_3 extends AppCompatActivity {

    Button science;
    Button edu;
    Button biz;
    Button agric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                , WindowManager.LayoutParams.FLAG_FULLSCREEN);

        science = (Button) findViewById(R.id.scie);
        edu =(Button) findViewById(R.id.edu);
        biz = (Button) findViewById(R.id.biz);
        agric =(Button) findViewById(R.id.agric);


        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://10.0.2.2/cvs/home.php"));
                startActivity(intent);
            }
        });

        edu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.rotimasols.com/education.php"));
                startActivity(intent);
            }

        });

        biz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.rotimasols.com/science.php"));
                startActivity(intent);
            }

        });

        agric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.rotimasols.com/agriculture.php"));
                startActivity(intent);
            }
        });
    }
}
