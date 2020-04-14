package ru.andreysozonov.popularlibrarytask1.standart.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.andreysozonov.popularlibrarytask1.R;
import ru.andreysozonov.popularlibrarytask1.standart.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = "MainActivity";
    private EditText editText;
    private Button buttonEnter;
    private TextView textViewResult;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        editText = findViewById(R.id.editText);
        buttonEnter = findViewById(R.id.buttonEnter);
        textViewResult = findViewById(R.id.textViewResult);

        mainPresenter = new MainPresenter(this);

        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.onButtonClick(editText.getText().toString());
            }
        });
    }

    public void setText(String message) {
        editText.setText("");
        textViewResult.setText(message);
    }

}
