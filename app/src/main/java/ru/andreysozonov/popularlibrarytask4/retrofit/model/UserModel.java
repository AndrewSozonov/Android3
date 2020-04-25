package ru.andreysozonov.popularlibrarytask4.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("avatar_url")
    private String userAvatarUrl;

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }
}
