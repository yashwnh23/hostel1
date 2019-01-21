package com.example.yashwanth.hostel1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class login extends AppCompatActivity {
    EditText e1, e2;
    Button but1;
    String result;
    String loginUrl;
    String data;
    OutputStream out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText3);
        but1 = (Button) findViewById(R.id.button2);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = e1.getText().toString();
                String password = e2.getText().toString();
                try {
                    data= URLEncoder.encode("username", "UTF-8")
                             + "=" + URLEncoder.encode(username, "UTF-8")+"&"+URLEncoder.encode("password", "UTF-8")
                            + "=" + URLEncoder.encode(password, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                loginUrl="http://hoteller.000webhostapp.com/logindb1.php?username="+username+"&password="+password;
               new  logindb1().execute();

            }
        });
    }


    public class logindb1 extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... voids) {
            try {
                URL url=new URL(loginUrl);
                HttpURLConnection con=(HttpURLConnection)url.openConnection();
                con.setRequestMethod("POST");
                out = new BufferedOutputStream(con.getOutputStream());

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
                writer.write(data);
                writer.flush();
                writer.close();
                con.connect();
                BufferedReader bf=new BufferedReader(new InputStreamReader(con.getInputStream()));
                String value=bf.readLine();
                result=value;
                System.out.println(value);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String aVoid) {
            Toast.makeText(login.this,result,Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }
}