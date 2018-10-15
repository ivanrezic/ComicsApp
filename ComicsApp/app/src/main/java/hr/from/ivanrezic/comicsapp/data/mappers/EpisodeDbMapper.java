package hr.from.ivanrezic.comicsapp.data.mappers;

import java.util.ArrayList;
import java.util.List;

import hr.from.ivanrezic.comicsapp.data.db.DbEpisode;
import hr.from.ivanrezic.comicsapp.data.details.ApiEpisode;
import hr.from.ivanrezic.comicsapp.domain.Episode;

public final class EpisodeDbMapper {

    public List<Episode> toEpisodes(final List<DbEpisode> list) {
        List<Episode> episodeList = new ArrayList<>();

        for (final DbEpisode dbEpisode : list) {
            episodeList.add(new Episode(dbEpisode.getEpisodeNumber(),
                                        dbEpisode.getName(),
                                        dbEpisode.getAirDate(),
                                        dbEpisode.getDescription(),
                                        dbEpisode.getImageUrl(),
                                        dbEpisode.getSeriesName(),
                                        dbEpisode.getEpisodeId(),
                                        dbEpisode.isFavorite()));
        }

        return episodeList;
    }

    public Episode toEpisode(final DbEpisode dbEpisode) {
        return new Episode(dbEpisode.getEpisodeNumber(),
                           dbEpisode.getName(),
                           dbEpisode.getAirDate(),
                           dbEpisode.getDescription(),
                           dbEpisode.getImageUrl(),
                           dbEpisode.getSeriesName(),
                           dbEpisode.getEpisodeId(),
                           dbEpisode.isFavorite());
    }

    public List<DbEpisode> toDbEpisodes(List<Episode> episodes) {
        List<DbEpisode> dbEpisodes = new ArrayList<>();

        for (final Episode episode : episodes) {
            dbEpisodes.add(new DbEpisode(episode.episodeNumber,
                                         episode.name,
                                         episode.airDate,
                                         episode.description,
                                         episode.imageUrl,
                                         episode.seriesName,
                                         episode.episodeId,
                                         episode.favorite));
        }

        return dbEpisodes;
    }

    public DbEpisode toDbEpisode(final Episode episode) {
        return new DbEpisode(episode.episodeNumber,
                             episode.name,
                             episode.airDate,
                             episode.description,
                             episode.imageUrl,
                             episode.seriesName,
                             episode.episodeId,
                             episode.favorite);
    }
}
