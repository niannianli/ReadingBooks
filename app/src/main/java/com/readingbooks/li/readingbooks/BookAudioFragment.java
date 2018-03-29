package com.readingbooks.li.readingbooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;;

public class BookAudioFragment extends Fragment {

    // we do not need a new activity to do new stuff, just add a framelayout to contain
    // new fragments, and set click listener just like using activity
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_audio, container, false);

        Button play, stop;
        play = (Button) v.findViewById(R.id.buttonPlay);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), MyUnboundService.class);
                getActivity().startService(myIntent);

            }
        });

        stop = (Button) v.findViewById(R.id.buttonStop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), MyUnboundService.class);
                getActivity().stopService(myIntent);
            }
        });
        return v;
    }
}

