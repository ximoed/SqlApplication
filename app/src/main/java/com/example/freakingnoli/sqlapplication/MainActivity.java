package com.example.freakingnoli.sqlapplication;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private NewDatabaseHelper dbHelper;
    private EditText mission_name;
    private EditText mission_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new NewDatabaseHelper(this, "Mission.db", null,1);

        mission_name = (EditText)findViewById(R.id.mission_name);
        mission_info = (EditText)findViewById(R.id.mission_info);

        Button saveBtn = (Button) findViewById(R.id.save_btn);
        Button recoverBtn = (Button) findViewById(R.id.recover_btn);

        saveBtn.setOnClickListener(this);
        recoverBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()){
            case R.id.save_btn:
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values= new ContentValues();
                String name = mission_name.getText().toString();
                String info = mission_info.getText().toString();
                values.put("name", name);
                values.put("extra_info", info);
                db.insert("mission", null, values);
                Toast.makeText(this,"data inserted!", Toast.LENGTH_LONG);
                break;
            case R.id.recover_btn:
                SQLiteDatabase dbReader = dbHelper.getReadableDatabase();
                //Cursor cursor = dbReader.query("mission", null, null, null, null, null, null);
                Cursor cursor = dbReader.rawQuery("select name,extra_info from mission order by id desc", null);

                if(cursor.moveToFirst()){
                    String existName = cursor.getString(cursor.getColumnIndex("name"));
                    String existMissionInfo = cursor.getString(cursor.getColumnIndex("extra_info"));
                    mission_name.setText(existName+"*");
                    mission_info.setText("*" + existMissionInfo);

                    dbReader.execSQL("update mission set name=?,extra_info=? where id=? ", new String[]{existName+"_1","1_"+existMissionInfo,"1"});

                    cursor.close();

                }
                break;
            default:
                break;

        }


    }
}
