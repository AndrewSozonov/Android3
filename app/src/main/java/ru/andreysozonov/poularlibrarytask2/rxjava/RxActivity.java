package ru.andreysozonov.poularlibrarytask2.rxjava;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.andreysozonov.poularlibrarytask2.R;

public class RxActivity extends AppCompatActivity {

    private static final String TAG = "RxActivity";
    private RxPresenter rxPresenter;
    private Observable<String> observable;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);

        rxPresenter = new RxPresenter();
        observable = rxPresenter.getMessages();

        Button buttonSubscribe = findViewById(R.id.buttonSubscribeRx);
        Button buttonUnsubscribe = findViewById(R.id.buttonUnsubscribeRx);

        buttonSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subscribe();
            }
        });

        buttonUnsubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unSubscribe();
            }
        });
    }

    public void subscribe() {
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: " + Thread.currentThread().getName());
                        RxActivity.this.disposable = d;
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext: " + Thread.currentThread().getName() + ": " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }

    public void unSubscribe() {
        disposable.dispose();
    }
}
