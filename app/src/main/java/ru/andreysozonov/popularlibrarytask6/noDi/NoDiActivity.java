package ru.andreysozonov.popularlibrarytask6.noDi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.andreysozonov.popularlibrarytask6.R;


public class NoDiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_di);

        Red red = new Red();
        White white = new White();

    }
}
