package hr.from.ivanrezic.comicsapp.domain.usecases;

import hr.from.ivanrezic.comicsapp.domain.Episode;
import hr.from.ivanrezic.comicsapp.domain.EpisodeRepository;
import io.reactivex.Flowable;

public final class FetchEpisodeDetailsUseCase implements FlowableUseCaseWithParameter<Episode, String> {

    private final EpisodeRepository episodeRepository;

    public FetchEpisodeDetailsUseCase(final EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public Flowable<Episode> execute(String episodeId) {
        return episodeRepository.getEpisodeDetails(episodeId);
    }
}
