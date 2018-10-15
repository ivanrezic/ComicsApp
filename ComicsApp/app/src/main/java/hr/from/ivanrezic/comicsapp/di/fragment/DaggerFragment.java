package hr.from.ivanrezic.comicsapp.di.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import hr.from.ivanrezic.comicsapp.di.ComponentFactory;

public abstract class DaggerFragment extends Fragment {

    private FragmentComponent fragmentComponent;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(getFragmentComponent());
    }

    public FragmentComponent getFragmentComponent() {
        if (fragmentComponent == null) {
            fragmentComponent = ComponentFactory.createFragmentComponent(this);
        }

        return fragmentComponent;
    }

    protected abstract void inject(FragmentComponent fragmentComponent);
}
