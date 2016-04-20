package com.example.freakingnoli.sqlapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Freakingnoli on 4/19/2016.
 */
public class NewDatabaseHelper extends SQLiteOpenHelper{
    public static final String CREATE_MISSION = "create table mission ("
            +"id integer primary key autoincrement,"
            +"name text,"
           // +"type integer,"
            //+"star integer,"
           // +"status integer,"
            +"extra_info text)";

    private Context mContext;

    public NewDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_MISSION);
        Log.d("sql_message", "create db");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}
