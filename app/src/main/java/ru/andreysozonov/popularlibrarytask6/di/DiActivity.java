package ru.andreysozonov.popularlibrarytask6.di;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.andreysozonov.popularlibrarytask6.R;

public class DiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_di);

        Green green = new Green();
        Red red = new Red(green);
        White white = new White(green);
    }
}
