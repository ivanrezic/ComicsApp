package hr.from.ivanrezic.comicsapp.di.activity.modules;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import hr.from.ivanrezic.comicsapp.di.activity.ActivityScope;
import hr.from.ivanrezic.comicsapp.di.activity.DaggerActivity;
import hr.from.ivanrezic.comicsapp.di.activity.ForActivity;

@Module
public class ActivityModule {

    private final DaggerActivity daggerActivity;

    public ActivityModule(final DaggerActivity daggerActivity) {this.daggerActivity = daggerActivity;}

    @Provides
    @ForActivity
    @ActivityScope
    Context provideActivityContext() {
        return daggerActivity;
    }

    @Provides
    @ActivityScope
    FragmentManager provideFragmentManager() {return daggerActivity.getSupportFragmentManager();}
}
