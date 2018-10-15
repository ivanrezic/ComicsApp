package hr.from.ivanrezic.comicsapp.di.application;

import javax.inject.Singleton;

import dagger.Component;
import hr.from.ivanrezic.comicsapp.di.activity.ActivityComponent;
import hr.from.ivanrezic.comicsapp.di.application.modules.ApplicationModule;
import hr.from.ivanrezic.comicsapp.di.application.modules.DataModule;
import hr.from.ivanrezic.comicsapp.di.application.modules.UseCasesModule;
import hr.from.ivanrezic.comicsapp.di.application.modules.UtilsModule;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                UtilsModule.class,
                DataModule.class,
                UseCasesModule.class
        }
)
public interface ApplicationComponent extends ApplicationComponentInjects {

    final class Initializer {

        public static ApplicationComponent init(final ComicsAppApplication comicsAppApplication) {
            return DaggerApplicationComponent.builder()
                                             .applicationModule(new ApplicationModule(comicsAppApplication))
                                             .utilsModule(new UtilsModule())
                                             .dataModule(new DataModule(comicsAppApplication))
                                             .useCasesModule(new UseCasesModule())
                                             .build();
        }

        private Initializer() {
        }
    }

    ActivityComponent.Builder activityComponentBuilder();
}