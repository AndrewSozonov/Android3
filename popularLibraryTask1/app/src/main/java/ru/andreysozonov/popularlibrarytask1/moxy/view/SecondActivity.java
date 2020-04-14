package ru.andreysozonov.popularlibrarytask1.moxy.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.andreysozonov.popularlibrarytask1.R;
import ru.andreysozonov.popularlibrarytask1.moxy.presenter.SecondPresenter;

public class SecondActivity extends MvpAppCompatActivity implements SecondView{

    private static final String TAG = "SecondActivity";
    private EditText editText;
    private Button buttonEnter;
    private TextView textViewResult;

    @InjectPresenter
    SecondPresenter secondPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate: ");

        editText = findViewById(R.id.editTextSecond);
        buttonEnter = findViewById(R.id.buttonEnterSecond);
        textViewResult = findViewById(R.id.textViewResultSecond);

        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondPresenter.onButtonClick(editText.getText().toString());

            }
        });
    }


    public void setResultText(String message) {
        editText.setText("");
        textViewResult.setText(message);
    }
}
