package ru.andreysozonov.popularlibrarytask6.dagger;

import android.util.Log;

import javax.inject.Inject;

import ru.andreysozonov.popularlibrarytask6.dagger.app.App;

public class White {

    private static final String TAG = "White";

    @Inject
    Green green;

    public White() {
        App.getAppComponent().inject(this);
        Log.d(TAG, "White " + green.show());
        Log.d(TAG, "White " + green);
    }
}
