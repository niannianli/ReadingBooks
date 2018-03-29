package com.readingbooks.li.readingbooks;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.os.Build;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import static android.os.Build.VERSION_CODES.M;

public class MyBoundServiceActivity extends AppCompatActivity {

    MyBoundService myService;
    boolean isBound=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound);
        if (Build.VERSION.SDK_INT >= M) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.INTERNET, Manifest.permission.ACCESS_WIFI_STATE,
                            Manifest.permission.ACCESS_NETWORK_STATE,
                            Manifest.permission.READ_EXTERNAL_STORAGE
                    }
                    , 1);
        }

    }

    protected void onStart(){
        super.onStart();
        Log.i("MyBoundServiceActivity","onStart called");
        Intent intent = new Intent(this,MyBoundService.class);
        //start service with binding
        bindService(intent, MyConnection, Context.BIND_AUTO_CREATE);

    }

    private ServiceConnection MyConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBoundService.LocalBinder binder=(MyBoundService.LocalBinder)service;
            myService=binder.getService();
            isBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound=false;
        }
    };

    public void downloadFile(View v){
// Download file
        myService.downloadFile("http://www.qwikisoft.com/demo/ashade/20001.kml");
            Toast.makeText(this, "File Downloaded", Toast.LENGTH_LONG).show();
    }

    protected void onStop(){
        super.onStop();
        Log.i("MyBoundServiceActivity","onStop called");
        if (isBound) {
            //unbind service
            unbindService(MyConnection);
            isBound = false;
        }
    }
}



