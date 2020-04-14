package ru.andreysozonov.popularlibrarytask1.moxy.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface SecondView extends MvpView {

    @StateStrategyType(value = AddToEndStrategy.class)
    void setResultText(String message);

}


