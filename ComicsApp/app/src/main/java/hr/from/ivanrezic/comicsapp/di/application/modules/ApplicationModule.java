package hr.from.ivanrezic.comicsapp.di.application.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hr.from.ivanrezic.comicsapp.di.application.ComicsAppApplication;
import hr.from.ivanrezic.comicsapp.di.application.ForApplication;

@Module
public final class ApplicationModule {

    private final ComicsAppApplication comicsAppApplication;

    public ApplicationModule(final ComicsAppApplication comicsAppApplication) {this.comicsAppApplication = comicsAppApplication;}

    @Provides
    @Singleton
    @ForApplication
    public ComicsAppApplication provideContext() {
        return comicsAppApplication;
    }
}
