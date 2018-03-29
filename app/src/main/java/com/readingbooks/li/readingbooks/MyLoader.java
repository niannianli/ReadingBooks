package com.readingbooks.li.readingbooks;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * What is a Loader? Loader is a set of APIs,
 * known as Loader APIs given by Android,
 * to load data asynchronously in activity/fragment.
 * What is the Use of Loader?
 * It can fetch data asynchronously
 * without blocking the main thread
 * and it manages it's own lifecycle during onDestroy() and configuration changes.
 */

public class MyLoader extends AsyncTaskLoader<Integer> {

    private int mSleepTime;

    public MyLoader(Context context, int sleepTime) {

        super(context);

        mSleepTime = sleepTime;

    }

    @Override

    public Integer loadInBackground() {

        try {

            Thread.sleep(mSleepTime);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        return mSleepTime;

    }

}
