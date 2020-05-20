package ru.andreysozonov.popularlibrarytask8.leak;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import ru.andreysozonov.popularlibrarytask8.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    private static InnerClass innerClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: " + MainActivity.this);



        if (innerClass == null) {
            innerClass = new InnerClass();
        }
    }
    class InnerClass {
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: " + MainActivity.this);
    }
}
