package ru.andreysozonov.popularlibrarytask4.gson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ru.andreysozonov.popularlibrarytask4.R;

public class GsonActivity extends AppCompatActivity {

    private static final String TAG = "GsonActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json = "{\"time_of_year\": \"summer\", \"year\": \"2019\"}";
        Gson gson = new GsonBuilder().create();
        YearModel yearModel = gson.fromJson(json,YearModel.class);

        Log.d(TAG, "onCreate: " + yearModel.timeOfYear);
        Log.d(TAG, "onCreate: " + yearModel.year);
    }
}
