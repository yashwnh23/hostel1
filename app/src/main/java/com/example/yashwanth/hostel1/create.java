package com.example.yashwanth.hostel1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class create extends SQLiteOpenHelper {
    public create(Context ctx) {
        super(ctx, "register.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table register(name varchar(20),email varchar(20),pass varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists register");
        onCreate(sqLiteDatabase);
    }
}
