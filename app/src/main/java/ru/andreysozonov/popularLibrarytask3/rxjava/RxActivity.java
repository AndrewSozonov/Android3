package ru.andreysozonov.popularLibrarytask3.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.andreysozonov.popularLibrarytask3.R;
import butterknife.OnClick;

public class RxActivity extends AppCompatActivity {

    private static final String TAG = "RxActivity";
    private RxPresenter rxPresenter;
    private Observable<String> observable;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        ButterKnife.bind(this);
        rxPresenter = new RxPresenter();
        observable = rxPresenter.getMessages();
    }

    @OnClick({R.id.buttonSubscribeRx})
    public void subscribe() {
        disposable = observable.observeOn(AndroidSchedulers.mainThread()).subscribe(string -> {
            Log.d(TAG, "onNext: " + Thread.currentThread().getName() + string);
        }, throwable -> Log.e(TAG, "onError"), () -> {
            Log.d(TAG, "onComplete: ");
        });
    }

    @OnClick({R.id.buttonUnsubscribeRx})
    public void unSubscribe() {
        disposable.dispose();
    }
}
