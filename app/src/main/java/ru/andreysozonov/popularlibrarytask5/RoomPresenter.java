package ru.andreysozonov.popularlibrarytask5;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RoomPresenter {

    private static final String TAG = "RoomPresenter";


    private UserDao userDao;

    public RoomPresenter() {
        userDao = App.getAppDatabase().userDao();
    }

    public void putUser() {
        User user = new User("Ivan", "Ivanov", 20);

        Disposable disposable = userDao.insert(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "putData: " + id);
                }, throwable -> {
                    Log.d(TAG, "putData: " + throwable);
                });
    }

    public void putUsers() {

        List<User> users = new ArrayList<>();
        users.add(new User("Petr", "Petrov", 25));
        users.add(new User("Igor", "Igorev", 30));
        users.add(new User("Sidor", "Sidorov", 35));

        Disposable disposable = userDao.insertList(users).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "putData: " + users.size() + " users");
                }, throwable -> {
                    Log.d(TAG, "putData: " + throwable);
                });
    }

    public void removeUser() {
        String surname = "Ivanov";

        Disposable disposable = userDao.delete(surname).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "deleteData: " + id);
                }, throwable -> {
                    Log.d(TAG, "deleteData: " + throwable);
                });
    }

    public void getAllUsers() {
        Disposable disposable = userDao.getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {
                    Log.d(TAG, "getData: " + users + " " + Thread.currentThread().getName());
                }, throwable -> {
                    Log.d(TAG, "getData: " + throwable);
                });
    }

    public void update() {

        User user = new User("Petr", "Petrov", 50);
        user.id = 2;

        Disposable disposable = userDao.update(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {
                    Log.d(TAG, "getData: " + users + " " + Thread.currentThread().getName());
                }, throwable -> {
                    Log.d(TAG, "getData: " + throwable);
                });
    }
}
