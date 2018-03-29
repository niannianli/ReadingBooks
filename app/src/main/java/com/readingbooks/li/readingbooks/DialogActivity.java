package com.readingbooks.li.readingbooks;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DialogActivity extends FragmentActivity {

    Button dFragButton;
    Button alertDFragButton;
    FragmentManager fm = getSupportFragmentManager();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        dFragButton = (Button) findViewById(R.id.dFragButton);
        alertDFragButton = (Button) findViewById(R.id.alertDFragButton);

        // Capture button clicks
        dFragButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                DFragment dFragment = new DFragment();
                // Show DialogFragment
                dFragment.show(fm, "Dialog Fragment");
            }
        });

        // Capture button clicks
        alertDFragButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                AlertDFragment alertdFragment = new AlertDFragment();
                // Show Alert DialogFragment
                alertdFragment.show(fm, "Alert Dialog Fragment");
            }
        });
    }
}