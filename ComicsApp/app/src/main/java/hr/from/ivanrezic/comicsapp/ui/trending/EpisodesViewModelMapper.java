package hr.from.ivanrezic.comicsapp.ui.trending;

import android.text.Html;

import java.util.ArrayList;
import java.util.List;

import hr.from.ivanrezic.comicsapp.domain.Episode;
import hr.from.ivanrezic.comicsapp.ui.details.EpisodeViewModel;

public final class EpisodesViewModelMapper {

    public TrendingViewModel toTrendingEpisodesViewModel(final List<Episode> episodes) {
        final List<EpisodeViewModel> episodeViewModelList = new ArrayList<>();

        for (final Episode episode : episodes) {
            episodeViewModelList.add(
                    new EpisodeViewModel(episode.episodeNumber,
                                         episode.name,
                                         episode.airDate,
                                         Html.fromHtml(episode.description).toString(),
                                         episode.imageUrl,
                                         episode.seriesName,
                                         episode.episodeId,
                                         episode.favorite));
        }

        return new TrendingViewModel(episodeViewModelList);
    }

    public EpisodeViewModel toEpisodeViewModel(final Episode episode) {
        return new EpisodeViewModel(episode.episodeNumber,
                                    episode.name,
                                    episode.airDate,
                                    Html.fromHtml(episode.description).toString(),
                                    episode.imageUrl,
                                    episode.seriesName,
                                    episode.episodeId,
                                    episode.favorite);
    }
}
