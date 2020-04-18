package ru.andreysozonov.poularlibrarytask2.observer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.andreysozonov.poularlibrarytask2.R;

public class ObserverActivity extends AppCompatActivity {

    SpamProducer spamProducer = new SpamProducer();
    User user = new User("user1");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);

        Button buttonSubscribe = findViewById(R.id.buttonSubscribe);
        Button buttonUnsubscribe = findViewById(R.id.buttonUnsubscribe);
        Button buttonSpam = findViewById(R.id.buttonSpam);

        buttonSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        buttonUnsubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unRegister();

            }
        });

        buttonSpam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spam();
            }
        });
    }

    public void register() {
        spamProducer.registerObserver(user);

    }

    public void unRegister() {
        spamProducer.unregisterObserver(user);

    }

    public void spam() {
        spamProducer.sendSpam();
    }
}
