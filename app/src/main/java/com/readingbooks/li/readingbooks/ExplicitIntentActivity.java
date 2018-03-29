package com.readingbooks.li.readingbooks;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

    public class ExplicitIntentActivity extends Activity {
        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_explicit);

            Button button1=(Button)findViewById(R.id.Button01);
            button1.setOnClickListener(new OnClickListener(){
                public void onClick(View view) {
                    Intent i = new Intent(ExplicitIntentActivity.this, ExplicitIntent2Activity.class);
                    i.putExtra("Value1", "Android By Javatpoint");
                    i.putExtra("Value2", "Simple Tutorial");
                    // Set the request code to any code you like, you can identify the
                    // callback via this code
                    startActivity(i);
                }
            });
        }
    }

