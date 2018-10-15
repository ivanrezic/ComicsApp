package hr.from.ivanrezic.comicsapp.di.fragment.modules;

import dagger.Module;
import dagger.Provides;
import hr.from.ivanrezic.comicsapp.di.fragment.DaggerFragment;
import hr.from.ivanrezic.comicsapp.di.fragment.FragmentScope;
import hr.from.ivanrezic.comicsapp.domain.usecases.FetchEpisodeDetailsUseCase;
import hr.from.ivanrezic.comicsapp.domain.usecases.FetchSearchResultsUseCase;
import hr.from.ivanrezic.comicsapp.domain.usecases.FetchTopTenEpisodesUseCase;
import hr.from.ivanrezic.comicsapp.domain.usecases.SetEpisodeAsFavoriteUseCase;
import hr.from.ivanrezic.comicsapp.ui.details.EpisodeDetailsContract;
import hr.from.ivanrezic.comicsapp.ui.details.EpisodeDetailsPresenter;
import hr.from.ivanrezic.comicsapp.ui.search.SearchContract;
import hr.from.ivanrezic.comicsapp.ui.search.SearchPresenter;
import hr.from.ivanrezic.comicsapp.ui.trending.EpisodesViewModelMapper;
import hr.from.ivanrezic.comicsapp.ui.trending.TrendingContract;
import hr.from.ivanrezic.comicsapp.ui.trending.TrendingPresenter;

@Module
public class FragmentPresenterModule {

    private final DaggerFragment daggerFragment;

    public FragmentPresenterModule(final DaggerFragment daggerFragment) {this.daggerFragment = daggerFragment;}

    @Provides
    @FragmentScope
    public TrendingContract.Presenter provideTrendingPresenter(final EpisodesViewModelMapper episodesViewModelMapper,
                                                               final FetchTopTenEpisodesUseCase fetchTopTenEpisodesUseCase,
                                                               final SetEpisodeAsFavoriteUseCase setEpisodeAsFavoriteUseCase) {
        return new TrendingPresenter((TrendingContract.View) daggerFragment,
                                     episodesViewModelMapper,
                                     fetchTopTenEpisodesUseCase,
                                     setEpisodeAsFavoriteUseCase);
    }

    @Provides
    @FragmentScope
    public EpisodeDetailsContract.Presenter provideEpisodeDetailsPresenter(final EpisodesViewModelMapper episodesViewModelMapper,
                                                                           final FetchEpisodeDetailsUseCase fetchEpisodeDetailsUseCase) {
        return new EpisodeDetailsPresenter((EpisodeDetailsContract.View) daggerFragment,
                                           episodesViewModelMapper,
                                           fetchEpisodeDetailsUseCase);
    }

    @Provides
    @FragmentScope
    public SearchContract.Presenter provideSearchPresenter(final FetchSearchResultsUseCase fetchSearchResultsUseCase) {
        return new SearchPresenter((SearchContract.View) daggerFragment,
                                   fetchSearchResultsUseCase);
    }
}
