package com.example.todoschedule;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ToDoDB";
    public static final String TABLE_TO_DO = "ToDo";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "_key";
    public static final String KEY_VAL = "value";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_TO_DO + "(" + KEY_ID
                + " integer primary key," + KEY_NAME + " text," + KEY_VAL + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_TO_DO);
        onCreate(db);

    }
}