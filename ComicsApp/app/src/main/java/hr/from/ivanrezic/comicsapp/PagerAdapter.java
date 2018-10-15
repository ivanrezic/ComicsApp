package hr.from.ivanrezic.comicsapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hr.from.ivanrezic.comicsapp.ui.search.SearchFragment;
import hr.from.ivanrezic.comicsapp.ui.trending.TrendingFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    private static int NUMBER_OF_TABS = 2;
    private static String PAGE_ONE_TITLE = "Top 10";
    private static String PAGE_TWO_TITLE = "Search";

    public PagerAdapter(final FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(final int position) {

        switch (position) {
            case 0:
                return TrendingFragment.newInstance();
            case 1:
                return SearchFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUMBER_OF_TABS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(final int position) {
        switch (position) {
            case 0:
                return PAGE_ONE_TITLE;
            case 1:
                return PAGE_TWO_TITLE;
            default:
                return null;
        }
    }
}
