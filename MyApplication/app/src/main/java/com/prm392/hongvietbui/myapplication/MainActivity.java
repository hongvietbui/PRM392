package com.prm392.hongvietbui.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnNotification;
    private EditText edtData;

    private void bindingView(){
        btnNotification = findViewById(R.id.btnNotification);
        edtData = findViewById(R.id.edtData);
    }

    private void bindingAction(){
        btnNotification.setOnClickListener(this::onBtnNotificationClick);
    }

    private void onBtnNotificationClick(View view){
        String data = edtData.getText().toString();
        sendNotification(data);
    }
    int id = 1;
    private void sendNotification(String data){
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("data", data);
        PendingIntent pi = PendingIntent.getActivity(this, 1231, i, PendingIntent.FLAG_MUTABLE|PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, "SE1730_CHANNEL_10")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("SE1730")
            .setContentText(data)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pi)
                .setAutoCancel(true)
            .build();

        NotificationManager manager = getSystemService(NotificationManager.class);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("SE1730_CHANNEL_10", "channelName", NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }

        manager.notify(id++, notification);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        bindingView();
        bindingAction();
        onReceiveIntent();
    }

    private void onReceiveIntent(){
        Intent  i = getIntent();
        String data = i.getStringExtra("data");
        if(data != null){
            edtData.setText(data);
        }
    }
}
