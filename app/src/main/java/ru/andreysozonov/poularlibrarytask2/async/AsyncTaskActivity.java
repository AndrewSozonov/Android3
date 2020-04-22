package ru.andreysozonov.poularlibrarytask2.async;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

import ru.andreysozonov.poularlibrarytask2.R;

public class AsyncTaskActivity extends AppCompatActivity {

    private static final String TAG = "AsyncTaskActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart = findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
    }

    private void start() {
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
        Log.d(TAG, "Start method complete");
    }

    private static class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                for (int i = 0; i < 5; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    Log.d(TAG, "doInBackGround" + Thread.currentThread().getName() + " " + i);
                }
            } catch (InterruptedException e) {
                Log.d(TAG, "" + e);
            }
            return null;
        }
    }
}
