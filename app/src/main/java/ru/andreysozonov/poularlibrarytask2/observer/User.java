package ru.andreysozonov.poularlibrarytask2.observer;

import android.util.Log;

public class User implements Observer {

    private static final String TAG = "User";
    private String name;

    public User(String name) {
        this.name = name;
    }


    @Override
    public void updateData(int number, String thread) {
        Log.d(TAG,  " " + name + " received spam " + number + " " + thread);
    }
}
