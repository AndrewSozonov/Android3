package ru.andreysozonov.popularLibrarytask3.rxjavasingle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import io.reactivex.Observable;
import io.reactivex.Single;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.andreysozonov.popularLibrarytask3.R;

public class RxActivitySingle extends AppCompatActivity {

    private static final String TAG = "RxActivitySingle";
    private RxPresenterSingle rxPresenterSingle;
    private Single<String> single;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_single);
        ButterKnife.bind(this);
        rxPresenterSingle = new RxPresenterSingle();
        single = rxPresenterSingle.getSingleMessage();

    }

    @OnClick({R.id.button_get_message})
    public void subscribe(View view) {
        disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(string -> Log.d(TAG, "subscribe1: " + string),
                throwable -> Log.e(TAG, "subscribe1: ", throwable));
    }
}
