package ru.andreysozonov.popularlibrarytask4.gson;

import com.google.gson.annotations.SerializedName;

public class YearModel {

    @SerializedName("time_of_year")
    public String timeOfYear;

    @SerializedName("year")
    public int year;
}
