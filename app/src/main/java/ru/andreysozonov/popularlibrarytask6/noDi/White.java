package ru.andreysozonov.popularlibrarytask6.noDi;

import android.util.Log;

public class White {

    private static final String TAG = "White";

    public White () {
        Green green = new Green();
        Log.d(TAG, "White " + green.show());
        Log.d(TAG, "White " + green);
    }
}
