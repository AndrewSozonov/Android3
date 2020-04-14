package ru.andreysozonov.popularlibrarytask1.standart.presenter;

import android.util.Log;

import ru.andreysozonov.popularlibrarytask1.standart.model.Model;
import ru.andreysozonov.popularlibrarytask1.standart.view.MainView;

public class MainPresenter {

    private static final String TAG = "MainPresenter";

    private MainView mainView;
    private Model model;

    public MainPresenter(MainView mainView) {
        Log.d(TAG, "MainPresenter: ");
        this.mainView = mainView;
        model = new Model();
    }

    public String addResult(String x, String y) {
        StringBuilder value = new StringBuilder();
        value.append(x);
        value.append(y);
        return value.toString();
    }

    public void onButtonClick(String text) {
        String oldText = model.getText();
        String newText = addResult(oldText, text);
        model.setResult(newText);
        mainView.setText(newText);
    }
}
