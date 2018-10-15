package hr.from.ivanrezic.comicsapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.from.ivanrezic.comicsapp.di.activity.ActivityComponent;
import hr.from.ivanrezic.comicsapp.di.activity.DaggerActivity;
import hr.from.ivanrezic.comicsapp.ui.search.SearchFragment;
import hr.from.ivanrezic.comicsapp.ui.trending.TrendingFragment;

public final class MainActivity extends DaggerActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @Inject
    public FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final PagerAdapter pagerAdapter = new PagerAdapter(fragmentManager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @OnClick(R.id.toolbar_search_action)
    public void onSearchActionClick() {
        fragmentManager.beginTransaction()
                       .add(R.id.main_container, SearchFragment.newInstance())
                       .addToBackStack(null)
                       .commit();
    }

    @Override
    protected void inject(final ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }
}
