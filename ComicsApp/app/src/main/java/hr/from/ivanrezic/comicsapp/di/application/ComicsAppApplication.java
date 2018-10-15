package hr.from.ivanrezic.comicsapp.di.application;

import android.app.Application;
import android.content.Context;

import hr.from.ivanrezic.comicsapp.di.ComponentFactory;

public final class ComicsAppApplication extends Application {

    private ApplicationComponent applicationComponent;

    public static ComicsAppApplication fromContext(final Context context) {
        return (ComicsAppApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = ComponentFactory.createApplicationComponent(this);
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
