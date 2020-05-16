package ru.andreysozonov.popularlibrarytask6.dagger;

import android.util.Log;

import javax.inject.Inject;

import ru.andreysozonov.popularlibrarytask6.dagger.app.App;

public class Red {

    private static final String TAG = "Red";

    @Inject
    Green green;

    public Red() {
        App.getAppComponent().inject(this);
        Log.d(TAG, "Red " + green.show());
        Log.d(TAG, "Red " + green);

    }
}
