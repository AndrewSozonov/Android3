package ru.andreysozonov.popularLibrarytask3.rxjavasingle;

import android.util.Log;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class RxPresenterSingle {

    private static final String TAG = "RxPresenterSingle";

    public Single<String> getSingleMessage() {
        Single<String> single = Single.create((SingleOnSubscribe<String>) emitter -> {
            String cup = "message ";
            Log.d(TAG, "received " + Thread.currentThread().getName() + ": " + cup);
            emitter.onSuccess(cup);
        }).subscribeOn(Schedulers.io());
        return single;
    }
}
