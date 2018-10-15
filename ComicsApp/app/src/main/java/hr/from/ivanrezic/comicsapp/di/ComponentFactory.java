package hr.from.ivanrezic.comicsapp.di;

import hr.from.ivanrezic.comicsapp.di.activity.ActivityComponent;
import hr.from.ivanrezic.comicsapp.di.activity.DaggerActivity;
import hr.from.ivanrezic.comicsapp.di.activity.ActivityComponent;
import hr.from.ivanrezic.comicsapp.di.activity.DaggerActivity;
import hr.from.ivanrezic.comicsapp.di.application.ApplicationComponent;
import hr.from.ivanrezic.comicsapp.di.application.ComicsAppApplication;
import hr.from.ivanrezic.comicsapp.di.fragment.DaggerFragment;
import hr.from.ivanrezic.comicsapp.di.fragment.FragmentComponent;

public final class ComponentFactory {

    private ComponentFactory() {
    }

    public static ApplicationComponent createApplicationComponent(final ComicsAppApplication comicsAppApplication) {
        return ApplicationComponent.Initializer.init(comicsAppApplication);
    }

    public static ActivityComponent createActivityComponent(final DaggerActivity daggerActivity) {
        return ActivityComponent.Initializer.init(ComicsAppApplication.fromContext(daggerActivity).getApplicationComponent(), daggerActivity);
    }

    public static FragmentComponent createFragmentComponent(final DaggerFragment daggerFragment) {
        return FragmentComponent.Initializer.init(((DaggerActivity) daggerFragment.getActivity()).getActivityComponent(), daggerFragment);
    }
}
