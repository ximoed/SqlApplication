package com.example.freakingnoli.sqlapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NoticeActivity extends AppCompatActivity {

    private static int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        TextView text = (TextView) findViewById(R.id.show_count);
        text.setText(Integer.toString(count));
        count++;
       // NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
       // notificationmanager.cancel(1);
    }
}
