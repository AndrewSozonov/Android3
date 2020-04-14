package ru.andreysozonov.popularlibrarytask1.moxy.presenter;

import android.util.Log;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.andreysozonov.popularlibrarytask1.moxy.model.SecondModel;
import ru.andreysozonov.popularlibrarytask1.moxy.view.SecondView;

@InjectViewState
public class SecondPresenter extends MvpPresenter<SecondView> {

    private static final String TAG = "SecondPresenter";
    private SecondModel model;

    public SecondPresenter() {
        Log.d(TAG, "SecondPresenter: ");
        this.model = new SecondModel();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        Log.d(TAG, "onFirstViewAttach: ");
    }

    public String addResult(String x, String y) {
        StringBuilder value = new StringBuilder();
        value.append(x);
        value.append(y);
        return value.toString();
    }

    public void onButtonClick(String text){
        String oldText = model.getText();
        String newText = addResult(oldText, text);
        model.setText(newText);
        getViewState().setResultText(newText);
    }


}
