package hr.from.ivanrezic.comicsapp.di.activity;

import dagger.Subcomponent;
import hr.from.ivanrezic.comicsapp.di.activity.modules.ActivityModule;
import hr.from.ivanrezic.comicsapp.di.application.ApplicationComponent;
import hr.from.ivanrezic.comicsapp.di.fragment.FragmentComponent;

@ActivityScope
@Subcomponent(
        modules = {
                ActivityModule.class
        }
)
public interface ActivityComponent extends ActivityComponentInjects {

    @Subcomponent.Builder
    interface Builder {

        Builder activityModule(ActivityModule activityModule);

        ActivityComponent build();
    }

    final class Initializer {

        public static ActivityComponent init(final ApplicationComponent applicationComponent, final DaggerActivity daggerActivity) {
            return applicationComponent.activityComponentBuilder()
                                       .activityModule(new ActivityModule(daggerActivity))
                                       .build();
        }

        private Initializer() {
        }
    }

    FragmentComponent.Builder fragmentComponentBuilder();
}
