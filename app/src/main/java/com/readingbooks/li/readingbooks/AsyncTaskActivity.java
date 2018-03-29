package com.readingbooks.li.readingbooks;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        new TestAsync().execute();
    }

    public class TestAsync extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... params) {
            StringBuffer response = null;
            URL url = null;
            try {

                url = new URL("http://www.omdbapi.com/?t=Game%20of%20Thrones&Season=1&Episode=1");

            } catch (MalformedURLException e) {

                e.printStackTrace();

            }
            try {

                HttpURLConnection httpsURLConnection = (HttpURLConnection) url.openConnection();
                httpsURLConnection.setRequestMethod("GET");
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(httpsURLConnection.getInputStream()));
                String inputLine;
                response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {

                    response.append(inputLine);

                }

            } catch (IOException e) {

                e.printStackTrace();

            }

            // response.toString();

            try {
                JSONObject jsonObject = new JSONObject(response.toString());
                String title = jsonObject.getString("Title");
                String rated = jsonObject.getString("Rated");
                JSONArray jsonArray = jsonObject.getJSONArray("");
                for(int i = 0; i<jsonArray.length(); i++){
                    Log.e("#####",jsonArray.getJSONObject(i).toString());
                }
                Log.e("#####",title + " " + rated);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
