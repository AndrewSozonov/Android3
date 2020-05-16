package ru.andreysozonov.popularlibrarytask6.dagger.app;
import javax.inject.Singleton;

import dagger.Component;
import ru.andreysozonov.popularlibrarytask6.dagger.DaggerActivity;
import ru.andreysozonov.popularlibrarytask6.dagger.Red;
import ru.andreysozonov.popularlibrarytask6.dagger.White;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(DaggerActivity daggerActivity);

    void inject(Red red);

    void inject(White white);
}
