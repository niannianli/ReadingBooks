package com.readingbooks.li.readingbooks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.v7.app.AppCompatActivity;

public class MyUnboundServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_audio);

        Button play, stop;
        play = (Button) findViewById(R.id.buttonPlay);
        play.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent myIntent = new Intent(MyUnboundServiceActivity.this, MyUnboundService.class);
                startService(myIntent);

            }
        });

        stop = (Button) findViewById(R.id.buttonStop);
        stop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MyUnboundServiceActivity.this, MyUnboundService.class);
                stopService(myIntent);
            }
        });

    }
}