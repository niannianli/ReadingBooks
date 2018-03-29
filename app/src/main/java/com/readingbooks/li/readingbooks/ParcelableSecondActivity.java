package com.readingbooks.li.readingbooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ParcelableSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable2);

        //get JSON object
        Intent intent = getIntent();
        //String suburb = intent.getStringExtra("name");
        //Integer age = intent.getIntExtra("age");

        Book book = intent.getParcelableExtra("book");

        String name = book.getName();
        Integer id = book.getId();
        String author = book.getAuthor();

        Toast.makeText(this,
                name + id + author,
                Toast.LENGTH_LONG)
                .show();
    }

}