package com.readingbooks.li.readingbooks;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyUnboundService extends Service{

    MediaPlayer myPlayer;
    public MyUnboundService() {
    }
    public IBinder onBind(Intent arg0) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        myPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
        myPlayer = MediaPlayer.create(this, R.raw.audiobook1);
        myPlayer.setLooping(false); // Set looping

    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
        myPlayer.stop();
    }
}
