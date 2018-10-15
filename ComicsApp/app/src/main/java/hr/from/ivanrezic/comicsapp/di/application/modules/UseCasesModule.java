package hr.from.ivanrezic.comicsapp.di.application.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hr.from.ivanrezic.comicsapp.domain.EpisodeRepository;
import hr.from.ivanrezic.comicsapp.domain.usecases.FetchEpisodeDetailsUseCase;
import hr.from.ivanrezic.comicsapp.domain.usecases.FetchSearchResultsUseCase;
import hr.from.ivanrezic.comicsapp.domain.usecases.FetchTopTenEpisodesUseCase;
import hr.from.ivanrezic.comicsapp.domain.usecases.SetEpisodeAsFavoriteUseCase;

@Module
public class UseCasesModule {

    @Provides
    @Singleton
    public FetchTopTenEpisodesUseCase provideFetchTopTenEpisodesUseCase(EpisodeRepository episodeRepository) {
        return new FetchTopTenEpisodesUseCase(episodeRepository);
    }

    @Provides
    @Singleton
    public SetEpisodeAsFavoriteUseCase provideSetEpisodeAsFavoriteUseCase(EpisodeRepository episodeRepository) {
        return new SetEpisodeAsFavoriteUseCase(episodeRepository);
    }

    @Provides
    @Singleton
    public FetchEpisodeDetailsUseCase provideFetchEpisodeDetailsUseCase(EpisodeRepository episodeRepository) {
        return new FetchEpisodeDetailsUseCase(episodeRepository);
    }

    @Provides
    @Singleton
    public FetchSearchResultsUseCase provideFetchSearchResultsUseCase(EpisodeRepository episodeRepository) {
        return new FetchSearchResultsUseCase(episodeRepository);
    }
}
