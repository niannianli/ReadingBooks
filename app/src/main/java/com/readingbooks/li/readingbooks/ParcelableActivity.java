package com.readingbooks.li.readingbooks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ParcelableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);

        Intent intent = new Intent();
        intent.putExtra("book", new Book(1,"Little Princess", "Mike"));

        Bundle data = getIntent().getExtras();
        Book book = (Book) data.getParcelable("book");

       // Toast.makeText()
        // only an example

    }
}
