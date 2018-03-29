package com.readingbooks.li.readingbooks;

import android.net.Uri;
        import android.os.Bundle;
        import android.app.Activity;
        import android.content.Intent;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.EditText;

public class ImplicitIntentActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
        final EditText editText1=(EditText)findViewById(R.id.editText1);
        Button button1=(Button)findViewById(R.id.buttonImplicit);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String url=editText1.getText().toString();
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });
    }
}