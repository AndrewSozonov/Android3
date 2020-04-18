package ru.andreysozonov.poularlibrarytask2.observer;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SpamProducer implements Observable {

    private static final String TAG = "SpamProducer";

    private ArrayList<Observer> arrayList;

    public SpamProducer() {
        arrayList = new ArrayList<>();

    }

    public void sendSpam() {
        MyAsyncTask task = new MyAsyncTask();
        task.execute();
    }

    @Override
    public void registerObserver(Observer observer) {
        Log.d(TAG, "registerObserver: ");
        arrayList.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        Log.d(TAG, "unregisterObserver: ");
        arrayList.remove(observer);

    }

    @Override
    public void notifyAllObservers(int number, String thread) {
        for (int i = 0; i < arrayList.size(); i++) {
            Observer observer = arrayList.get(i);
            observer.updateData(number, thread);
        }
    }

    private class MyAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                for (int i = 0; i < 10; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    String thread = Thread.currentThread().getName();
                    notifyAllObservers(i, thread);
                }
            } catch (InterruptedException e) {
                Log.d(TAG, "" + e);
            }
            return null;
        }
    }
}
