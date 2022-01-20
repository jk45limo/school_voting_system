package com.example.campusvotingsystemcvs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button _btnlLog;
    EditText _txtregno, _txtpassword;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _btnlLog=findViewById(R.id.btnlogin);
        _txtregno=findViewById(R.id.txtregno);
        _txtpassword= findViewById(R.id.txtpassword);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
        , WindowManager.LayoutParams.FLAG_FULLSCREEN);


        _btnlLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String reg_no = _txtregno.getText().toString();
                String pass_word= _txtpassword.getText().toString();
                String type="login";

                Intent intent = new Intent(MainActivity.this, click.class);

                startActivity( intent);



                BackgroundTask backgroundTask= new BackgroundTask(getApplicationContext());
                backgroundTask.execute(type,reg_no, pass_word);
            }
        });







    }
}
