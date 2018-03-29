package com.readingbooks.li.readingbooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TestActivity1 extends AppCompatActivity

    {

        @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_1);

            final Button button8 = findViewById(R.id.test8);
            //interface
            button8.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(TestActivity1.this, DialogActivity.class);
                    startActivity(intent);
                }
            });

            final Button button10 = findViewById(R.id.test10);
            //interface
            button10.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(TestActivity1.this, ParcelableFirstActivity.class);
                    startActivity(intent);
                }
            });

            final Button button11 = findViewById(R.id.test11);
            //interface
            button11.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(TestActivity1.this, ImplicitIntentActivity.class);
                    startActivity(intent);
                }
            });

            final Button button12 = findViewById(R.id.test12);
            //interface
            button12.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(TestActivity1.this, ExplicitIntentActivity.class);
                    startActivity(intent);
                }
            });

            final Button button13 = findViewById(R.id.test13);
            //interface
            button13.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(TestActivity1.this, JSONActivity.class);
                    startActivity(intent);
                }
            });

            final Button button14 = findViewById(R.id.test14);
            //interface
            button14.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(TestActivity1.this, ExternalActivity.class);
                    startActivity(intent);
                }
            });

            final Button button15 = findViewById(R.id.test15);
            //interface
            button15.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(TestActivity1.this, InternalStorageActivity.class);
                    startActivity(intent);
                }
            });

        }
    }

