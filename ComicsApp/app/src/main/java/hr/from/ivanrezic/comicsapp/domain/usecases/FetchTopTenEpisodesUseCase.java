package hr.from.ivanrezic.comicsapp.domain.usecases;

import java.util.List;

import hr.from.ivanrezic.comicsapp.domain.Episode;
import hr.from.ivanrezic.comicsapp.domain.EpisodeRepository;
import io.reactivex.Flowable;

public final class FetchTopTenEpisodesUseCase implements FlowableUseCase<List<Episode>> {

    private final EpisodeRepository episodeRepository;

    public FetchTopTenEpisodesUseCase(final EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public Flowable<List<Episode>> execute() {
        return episodeRepository.getTopTenEpisodes();
    }
}
