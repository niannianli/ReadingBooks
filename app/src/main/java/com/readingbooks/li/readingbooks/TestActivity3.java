package com.readingbooks.li.readingbooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TestActivity3 extends AppCompatActivity

{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_3);

        final Button button16 = findViewById(R.id.test16);
        //interface
        button16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity3.this, PreferencesActivity.class);
                startActivity(intent);
            }
        });

        final Button button17 = findViewById(R.id.test17);
        //interface
        button17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity3.this, PermissionActivity.class);
                startActivity(intent);
            }
        });

        final Button button18 = findViewById(R.id.test18);
        //interface
        button18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity3.this, NotificationActivity.class);
                startActivity(intent);
            }
        });

        final Button button19 = findViewById(R.id.test19);
        //interface
        button19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity3.this, BookActivity.class);
                startActivity(intent);
            }
        });

        final Button button20 = findViewById(R.id.test20);
        //interface
        button20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity3.this, AsyncTaskActivity.class);
                startActivity(intent);
            }
        });

    }
}
