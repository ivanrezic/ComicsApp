package hr.from.ivanrezic.comicsapp.domain.usecases;

import hr.from.ivanrezic.comicsapp.domain.EpisodeRepository;
import io.reactivex.Completable;

public final class SetEpisodeAsFavoriteUseCase implements CompletableUseCaseWithParameter<SetEpisodeAsFavoriteUseCase.Parameters> {

    private final EpisodeRepository episodeRepository;

    public SetEpisodeAsFavoriteUseCase(final EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public Completable execute(final Parameters parameter) {
        return episodeRepository.updateDbEpisode(parameter.episodeId, parameter.favorite);
    }

    public static class Parameters {

        public final String episodeId;
        public final boolean favorite;

        public Parameters(final String episodeId, final boolean favorite) {
            this.episodeId = episodeId;
            this.favorite = favorite;
        }
    }
}
