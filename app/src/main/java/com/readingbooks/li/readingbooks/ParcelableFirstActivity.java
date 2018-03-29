package com.readingbooks.li.readingbooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ParcelableFirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);

        //set JSON object
        Intent intent = new Intent(ParcelableFirstActivity.this, ParcelableSecondActivity.class);
     //   intent.putExtra("name", "John Smith");
       // intent.putExtra("age", 26);
        intent.putExtra("book", new Book(1,"GoT", "Mike"));
        startActivity(intent);
    }
}