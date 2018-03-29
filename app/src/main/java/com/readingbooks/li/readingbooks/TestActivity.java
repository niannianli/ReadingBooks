package com.readingbooks.li.readingbooks;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.widget.EditText;

public class TestActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        final Button button3 = findViewById(R.id.test3);
        //interface
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity.this, SavingFragmentActivity.class);
                startActivity(intent);
            }
        });

        final Button button33 = findViewById(R.id.test33);
        //interface
        button33.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity.this, SavingOrientationActivity.class);
                startActivity(intent);
            }
        });

        final Button button2 = findViewById(R.id.test2);
        //interface
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity.this, HandlerProgressActivity.class);
                startActivity(intent);
            }
        });

        final Button button44 = findViewById(R.id.test44);
        //interface
        button44.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoaderFragment mainFragment = new LoaderFragment();
                //mainFragment.setArguments(getIntent().getExtras());
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fragment_container_test, mainFragment);
                transaction.commit();
            }
        });

        final Button button4 = findViewById(R.id.test4);
        //interface
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MaterialFragment mainFragment = new MaterialFragment();
                //mainFragment.setArguments(getIntent().getExtras());
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container_test, mainFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


       /* final Button button = findViewById(R.id.test5);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainFragment mainFragment = new MainFragment();
                // In case this activity was started with special instructions from an
                // Intent, pass the Intent's extras to the fragment as arguments
                mainFragment.setArguments(getIntent().getExtras());
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //  transaction.add(R.id.fragment_container, oldFragment);
                transaction.commit();
            }
        });*/

        /*final Button button2 = findViewById(R.id.test6);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TaskFragment newFragment = new TaskFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });*/

     /*   final Button button7 = findViewById(R.id.test7);
        //interface
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.plain_text_input);
                String userInput = editText.getText().toString();
                Intent intent = new Intent(TestActivity.this, MainActivity.class);
                intent.putExtra("userInput", userInput);
                startActivity(intent);
            }
        });*/

    }
}