package hr.from.ivanrezic.comicsapp.ui.details;

import hr.from.ivanrezic.comicsapp.domain.Episode;
import hr.from.ivanrezic.comicsapp.domain.usecases.FetchEpisodeDetailsUseCase;
import hr.from.ivanrezic.comicsapp.ui.trending.EpisodesViewModelMapper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public final class EpisodeDetailsPresenter implements EpisodeDetailsContract.Presenter {

    private final EpisodeDetailsContract.View episodeDetailsView;
    private final EpisodesViewModelMapper episodesViewModelMapper;
    private final FetchEpisodeDetailsUseCase fetchEpisodeDetailsUseCase;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public EpisodeDetailsPresenter(final EpisodeDetailsContract.View episodeDetailsView,
                                   final EpisodesViewModelMapper episodesViewModelMapper,
                                   final FetchEpisodeDetailsUseCase fetchEpisodeDetailsUseCase) {
        this.episodeDetailsView = episodeDetailsView;
        this.episodesViewModelMapper = episodesViewModelMapper;
        this.fetchEpisodeDetailsUseCase = fetchEpisodeDetailsUseCase;
    }

    @Override
    public void start(final String episodeId) {
        compositeDisposable.add(fetchEpisodeDetailsUseCase.execute(episodeId)
                                                 .subscribeOn(Schedulers.io())
                                                 .observeOn(AndroidSchedulers.mainThread())
                                                 .subscribe(this::onEpisodeDetailsFetch,
                                                            this::onEpisodeDetailsError));
    }

    @Override
    public void clear() {
        compositeDisposable.clear();
    }

    public void onEpisodeDetailsFetch(final Episode episode) {
        episodeDetailsView.render(episodesViewModelMapper.toEpisodeViewModel(episode));
    }

    public void onEpisodeDetailsError(final Throwable throwable) {
        throwable.printStackTrace();
    }
}
