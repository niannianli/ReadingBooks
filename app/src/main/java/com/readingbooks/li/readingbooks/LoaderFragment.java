package com.readingbooks.li.readingbooks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class LoaderFragment extends Fragment

        implements LoaderManager.LoaderCallbacks<Integer>{

    private final static int TASK_ID_A = 1;

    private final static int TASK_ID_B = 2;

    private final static int TASK_ID_C = 3;

    public LoaderFragment() {

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_loader, container, false);

        Button submitButton = (Button) rootView.findViewById(R.id.loaderButton);

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                getLoaderManager().initLoader(TASK_ID_A, null, LoaderFragment.this).forceLoad();

                getLoaderManager().initLoader(TASK_ID_B, null, LoaderFragment.this).forceLoad();

                getLoaderManager().initLoader(TASK_ID_C, null, LoaderFragment.this).forceLoad();

            }

        });

        return rootView;

    }

    @Override

    public Loader<Integer> onCreateLoader(int i, Bundle bundle) {

        switch(i) {

            case TASK_ID_A:

                return new MyLoader(getActivity(), 100);

            case TASK_ID_B:

                return new MyLoader(getActivity(), 500);

            case TASK_ID_C:

                return new MyLoader(getActivity(), 250);

            default:

                return new MyLoader(getActivity(), 1);

        }

    }

    @Override

    public void onLoadFinished(Loader<Integer> integerLoader, Integer integer) {

        Toast.makeText(getActivity(), "onLoadFinished for " + integerLoader, Toast.LENGTH_LONG);

    }

    @Override

    public void onLoaderReset(Loader<Integer> integerLoader) {

    }

}
