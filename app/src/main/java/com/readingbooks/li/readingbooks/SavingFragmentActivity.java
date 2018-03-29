package com.readingbooks.li.readingbooks;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

public class SavingFragmentActivity extends Activity implements TaskFragment.TaskCallbacks {

        private static final String TAG_TASK_FRAGMENT = "task_fragment";

        private TaskFragment mTaskFragment;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_save);

            FragmentManager fm = getFragmentManager();
     //  mTaskFragment = (TaskFragment) fm.findFragmentByTag(TAG_TASK_FRAGMENT);

            // If the Fragment is non-null, then it is currently being
            // retained across a configuration change.
            if (mTaskFragment == null) {
                mTaskFragment = new TaskFragment();
        //        fm.beginTransaction().add(mTaskFragment, TAG_TASK_FRAGMENT).commit();
            }

            // TODO: initialize views, restore saved state, etc.
        }

        // The four methods below are called by the TaskFragment when new
        // progress updates or results are available. The MainActivity
        // should respond by updating its UI to indicate the change.

        @Override
        public void onPreExecute() { }

        @Override
        public void onProgressUpdate(int percent) {  }

        @Override
        public void onCancelled() { }

        @Override
        public void onPostExecute() {  }
    }
