package com.readingbooks.li.readingbooks;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BRActivity extends AppCompatActivity {

    MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_br);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(getPackageName() + "android.net.conn.CONNECTIVITY_CHANGE");

        myReceiver = new MyReceiver();
        registerReceiver(myReceiver, intentFilter);

        Button button = (Button) findViewById(R.id.button_send_broadcast);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("com.journaldev.CUSTOM_INTENT");
              //  intent.putExtra("test", "test");
                sendBroadcast(intent);
            }
        });

    }

    @Override
    protected void onStop() {
        unregisterReceiver(myReceiver);
        super.onStop();
    }

}
