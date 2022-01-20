package com.example.campusvotingsystemcvs;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String, String, String> {
    Context context;
    BackgroundTask (Context ctx){

        this.context=ctx;
    }


    @Override
    protected String doInBackground(String... strings) {


        String type= strings[0];

        String loginURL = "http://10.0.2.2:8089/cvs/index.php";

        if (type.equals("login")){



            String reg_no = strings[1];
            String pass_word = strings[2];

            try {
                URL url = new URL( loginURL);

                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");

                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outputStream, "UTF-8");
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                String login_data  = URLEncoder.encode( "regno", "UTF-8")+"="+URLEncoder.encode(reg_no, "UTF-8")+
                        "&"+URLEncoder.encode("password", "UTF-8" )+"="+URLEncoder.encode(pass_word, "UTF-8");

                bufferedWriter.write(login_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                InputStream  inputStream= httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");

                BufferedReader bufferedReader=   new BufferedReader(inputStreamReader);


                String result = "";
                String line = "";


                StringBuilder stringBuilder = new StringBuilder();
                while ((line=bufferedReader.readLine())!= null){

                    stringBuilder.append(line).append("\n");

                }
                result= stringBuilder.toString();
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return  result;


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
        //super.onPostExecute(s);
    }
}

