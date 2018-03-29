package com.readingbooks.li.readingbooks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MySimpleJSONAdapter extends SimpleAdapter {

    private ArrayList<HashMap<String, String>> results;
    private Context context;
    public MySimpleJSONAdapter(Context context,
                           ArrayList<HashMap<String, String>> data, int resource,
                           String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.results = data;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View v = view;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item, null);
        }

        return v;
    }
}