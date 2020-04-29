package ru.andreysozonov.popularlibrarytask4.retrofit;


import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface RetrofitView extends MvpView {

    @StateStrategyType(value = AddToEndStrategy.class)
    void setImage(String url);


}
