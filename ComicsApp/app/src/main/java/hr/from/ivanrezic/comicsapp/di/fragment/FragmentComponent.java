package hr.from.ivanrezic.comicsapp.di.fragment;

import android.app.FragmentManager;

import dagger.Subcomponent;
import hr.from.ivanrezic.comicsapp.di.activity.ActivityComponent;
import hr.from.ivanrezic.comicsapp.di.fragment.modules.FragmentPresenterModule;

@FragmentScope
@Subcomponent(
        modules = {
                FragmentPresenterModule.class
        })
public interface FragmentComponent extends FragmentComponentInject {

    @Subcomponent.Builder
    interface Builder {

        Builder fragmentPresenterModule(FragmentPresenterModule fragmentPresenterModule);

        FragmentComponent build();
    }

    final class Initializer {

        public static FragmentComponent init(final ActivityComponent activityComponent, final DaggerFragment daggerFragment) {
            return activityComponent.fragmentComponentBuilder()
                                    .fragmentPresenterModule(new FragmentPresenterModule(daggerFragment))
                                    .build();
        }
    }
}
