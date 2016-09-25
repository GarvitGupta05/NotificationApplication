package com.example.garvitgupta.notificationapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    Button notify;
    EditText tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notify = (Button) findViewById(R.id.button);
        tv = (EditText) findViewById(R.id.textView);

        notify.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Notify(tv.getText().toString());
    }

    private void Notify(String str) {

        NotificationManager  notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification notification  = new Notification(R.drawable.cubic,"Notification Application",System.currentTimeMillis());

        Intent notificationIntent = new Intent(this,MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        notification.setLatestEventInfo(MainActivity.this,"Notification Application",str,pendingIntent);
        notificationManager.notify(9999,notification);
    }
}
