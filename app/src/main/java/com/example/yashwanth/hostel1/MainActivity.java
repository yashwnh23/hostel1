package com.example.yashwanth.hostel1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button but;
    long row;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    create dbHelper=new create(this);
//        SQLiteDatabase db=dbHelper.getWritableDatabase();
//        ContentValues val=new ContentValues();
//
//        val.put("name","yash");
//        val.put("email","yash");
//        val.put("pass","yash");
//        row=db.insert("register",null,val);
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String pro[]={"name","email"};
        Cursor c=db.query("register",pro,null,null,null,null,null);
        c.moveToFirst();
        s=c.getString(1);
        but=(Button)findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"number is "+s,Toast.LENGTH_LONG).show();
                Intent i=new Intent(MainActivity.this,login.class);
                startActivity(i);
            }
        });
    }

}
