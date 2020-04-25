package ru.andreysozonov.popularlibrarytask4.retrofit.presenter;

import android.util.Log;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.andreysozonov.popularlibrarytask4.retrofit.RetrofitView;
import ru.andreysozonov.popularlibrarytask4.retrofit.model.RetrofitApi;
import ru.andreysozonov.popularlibrarytask4.retrofit.model.UserModel;
import io.reactivex.android.schedulers.AndroidSchedulers;

@InjectViewState
public class RetrofitPresenter extends MvpPresenter<RetrofitView> {

    public static final String TAG = "RetrofitPresenter";

    RetrofitApi retrofitApi;

    public RetrofitPresenter() {
        retrofitApi = new RetrofitApi();
    }

    public void getUrl() {

        Single<UserModel> single = retrofitApi.requestServer();
        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(user -> getViewState().setImage(user.getUserAvatarUrl()), throwable -> {
            Log.e(TAG, "onError");
        });
    }
}
