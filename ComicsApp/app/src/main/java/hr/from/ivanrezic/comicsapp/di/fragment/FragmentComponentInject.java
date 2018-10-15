package hr.from.ivanrezic.comicsapp.di.fragment;

import hr.from.ivanrezic.comicsapp.ui.details.EpisodeDetailsFragment;
import hr.from.ivanrezic.comicsapp.ui.search.SearchFragment;
import hr.from.ivanrezic.comicsapp.ui.trending.TrendingFragment;

public interface FragmentComponentInject {

    void inject(EpisodeDetailsFragment episodeDetailsFragment);

    void inject(TrendingFragment trendingFragment);

    void inject(SearchFragment searchFragment);
}
