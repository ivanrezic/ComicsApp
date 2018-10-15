package hr.from.ivanrezic.comicsapp.ui.trending;

import android.util.Log;

import java.util.List;

import hr.from.ivanrezic.comicsapp.domain.Episode;
import hr.from.ivanrezic.comicsapp.domain.usecases.CompletableUseCaseWithParameter;
import hr.from.ivanrezic.comicsapp.domain.usecases.FetchTopTenEpisodesUseCase;
import hr.from.ivanrezic.comicsapp.domain.usecases.SetEpisodeAsFavoriteUseCase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public final class TrendingPresenter implements TrendingContract.Presenter {

    private final TrendingContract.View trendingView;
    private final EpisodesViewModelMapper episodesViewModelMapper;
    private final FetchTopTenEpisodesUseCase fetchTopTenEpisodesUseCase;
    private final SetEpisodeAsFavoriteUseCase setEpisodeAsFavoriteUseCase;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public TrendingPresenter(final TrendingContract.View trendingView,
                             final EpisodesViewModelMapper episodesViewModelMapper,
                             final FetchTopTenEpisodesUseCase fetchTopTenEpisodesUseCase,
                             final SetEpisodeAsFavoriteUseCase setEpisodeAsFavoriteUseCase) {
        this.trendingView = trendingView;
        this.episodesViewModelMapper = episodesViewModelMapper;
        this.fetchTopTenEpisodesUseCase = fetchTopTenEpisodesUseCase;
        this.setEpisodeAsFavoriteUseCase = setEpisodeAsFavoriteUseCase;
    }

    @Override
    public void start() {
        getTopTenEpisodes();
    }

    @Override
    public void refresh() {
        getTopTenEpisodes();
    }

    @Override
    public void clickFavorite(final String episodeId, final boolean favorite) {
        compositeDisposable.add(setEpisodeAsFavoriteUseCase.execute(new SetEpisodeAsFavoriteUseCase.Parameters(episodeId, favorite))
                                                           .subscribeOn(Schedulers.io())
                                                           .observeOn(AndroidSchedulers.mainThread())
                                                           .subscribe(this::onSetEpisodeFavoriteSuccess, this::onSetEpisodeFavoriteError));
    }

    @Override
    public void clear() {
        compositeDisposable.clear();
    }

    private void getTopTenEpisodes() {
        compositeDisposable.add(fetchTopTenEpisodesUseCase.execute()
                                                          .subscribeOn(Schedulers.io())
                                                          .observeOn(AndroidSchedulers.mainThread())
                                                          .subscribe(this::onTopTenEpisodesFetch,
                                                                     this::onTopTenEpisodesError));
    }

    private void onTopTenEpisodesFetch(final List<Episode> topTenEpisodes) {
        trendingView.render(getTrendingViewModel(topTenEpisodes));
    }

    private void onTopTenEpisodesError(final Throwable throwable) {
        throwable.printStackTrace();
    }

    private void onSetEpisodeFavoriteSuccess() {
        Log.i("Favorite", "Updated Correctly");
    }

    private void onSetEpisodeFavoriteError(final Throwable throwable) {
        throwable.printStackTrace();
    }

    private TrendingViewModel getTrendingViewModel(final List<Episode> topTenEpisodes) {
        return episodesViewModelMapper.toTrendingEpisodesViewModel(topTenEpisodes);
    }
}
