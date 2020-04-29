package ru.andreysozonov.popularlibrarytask4.retrofit.model;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("/users/{user}")
    Single<UserModel> getUser(@Path("user") String user);
}