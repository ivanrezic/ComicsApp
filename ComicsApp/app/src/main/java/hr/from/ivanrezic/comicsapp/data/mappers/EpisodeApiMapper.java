package hr.from.ivanrezic.comicsapp.data.mappers;

import java.util.ArrayList;
import java.util.List;

import hr.from.ivanrezic.comicsapp.data.details.ApiEpisode;
import hr.from.ivanrezic.comicsapp.domain.Episode;

import static hr.from.ivanrezic.comicsapp.utils.Util.validateProperty;

public final class EpisodeApiMapper {

    public static final int URL_INDEX_OF_FIRST_CHARACTER = 0;
    public static final String URL_LAST_CHARACTER = "/";
    public static final String URL_UNNDEED_PART = "https://comicvine.gamespot.com/api/episode/";

    public List<Episode> toEpisodes(final List<ApiEpisode> list) {
        List<Episode> episodeList = new ArrayList<>();

        for (final ApiEpisode apiEpisode : list) {
            episodeList.add(new Episode(validateProperty(apiEpisode.episodeNumber, "episode number"),
                                        validateProperty(apiEpisode.name, "name"),
                                        validateProperty(apiEpisode.airDate, "air date"),
                                        validateProperty(apiEpisode.description, "description"),
                                        validateProperty(apiEpisode.imageUrls.mediumUrl, "image url"),
                                        validateProperty(apiEpisode.series.name, "series name"),
                                        extractEpisodeId(apiEpisode.episodeDetailsUrl),
                                        false));
        }

        return episodeList;
    }

    public Episode toEpisode(final ApiEpisode apiEpisode) {
        return new Episode(validateProperty(apiEpisode.episodeNumber, "episode number"),
                           validateProperty(apiEpisode.name, "name"),
                           validateProperty(apiEpisode.airDate, "air date"),
                           validateProperty(apiEpisode.description, "description"),
                           validateProperty(apiEpisode.imageUrls.largeUrl, "image url"),
                           validateProperty(apiEpisode.series.name, "series name"),
                           extractEpisodeId(apiEpisode.episodeDetailsUrl),
                           false);
    }

    private String extractEpisodeId(final String episodeDetailsUrl) {
        return episodeDetailsUrl.substring(URL_INDEX_OF_FIRST_CHARACTER, episodeDetailsUrl.lastIndexOf(URL_LAST_CHARACTER)).replaceAll(URL_UNNDEED_PART, "");
    }
}
