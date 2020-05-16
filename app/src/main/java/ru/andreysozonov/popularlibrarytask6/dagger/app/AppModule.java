package ru.andreysozonov.popularlibrarytask6.dagger.app;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.andreysozonov.popularlibrarytask6.dagger.Green;


@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Green provideGreen() {
        return new Green();
    }
}
