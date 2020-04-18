package ru.andreysozonov.poularlibrarytask2.rxjava;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class RxPresenter {

    private static final String TAG = "RxPresenter";


    public Observable<String> getMessages() {

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    for (int i = 0; i < 10; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        String message = "message" + i;
                        Log.d(TAG, "recieved " + message + " " + Thread.currentThread().getName());
                        emitter.onNext(message);
                    }
                    emitter.onComplete();

                } catch (InterruptedException e) {
                    Log.d(TAG, "getMessages: not disposed");
                }
            }
        }).subscribeOn(Schedulers.io());
        return observable;
    }
}
