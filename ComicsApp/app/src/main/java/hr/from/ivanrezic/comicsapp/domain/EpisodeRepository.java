package hr.from.ivanrezic.comicsapp.domain;

import java.util.List;

import hr.from.ivanrezic.comicsapp.ui.search.SearchViewModel;
import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface EpisodeRepository {

    Flowable<List<Episode>> getTopTenEpisodes();

    Flowable<Episode> getEpisodeDetails(String episodeId);

    Completable updateDbEpisode(String episodeId, boolean favorite);

    Flowable<List<SearchViewModel>> getSearchResults(String query);
}
