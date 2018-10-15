package hr.from.ivanrezic.comicsapp.data.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hr.from.ivanrezic.comicsapp.data.db.ComicAppDatabase;
import hr.from.ivanrezic.comicsapp.data.db.DbEpisode;
import hr.from.ivanrezic.comicsapp.data.details.ApiEpisode;
import hr.from.ivanrezic.comicsapp.data.mappers.EpisodeApiMapper;
import hr.from.ivanrezic.comicsapp.data.mappers.EpisodeDbMapper;
import hr.from.ivanrezic.comicsapp.data.mappers.SearchApiMapper;
import hr.from.ivanrezic.comicsapp.data.search.SearchService;
import hr.from.ivanrezic.comicsapp.data.trending.TrendingService;
import hr.from.ivanrezic.comicsapp.domain.Episode;
import hr.from.ivanrezic.comicsapp.domain.EpisodeRepository;
import hr.from.ivanrezic.comicsapp.ui.search.SearchViewModel;
import io.reactivex.Completable;
import io.reactivex.Flowable;

public final class EpisodeRepositoryImpl implements EpisodeRepository {

    private static final String API_KEY = "2e7a75541721af0132f5c1c7729619708a8c3438";
    private static final int NUMBER_OF_EPISODES = 100;
    public static final int FIRST_INDEX_OF_RANDOM_SUBLIST = 0;
    public static final int LAST_INDEX_OF_RANDOM_SUBLIST = 10;

    private final TrendingService trendingService;
    private final EpisodeApiMapper episodeApiMapper;
    private final ComicAppDatabase comicAppDatabase;
    private final EpisodeDbMapper episodeDbMapper;
    private final SearchService searchService;
    private final SearchApiMapper searchApiMapper;

    public EpisodeRepositoryImpl(final TrendingService trendingService,
                                 final SearchService searchService,
                                 final EpisodeApiMapper episodeApiMapper,
                                 final ComicAppDatabase comicAppDatabase,
                                 final EpisodeDbMapper episodeDbMapper,
                                 final SearchApiMapper searchApiMapper) {
        this.trendingService = trendingService;
        this.episodeApiMapper = episodeApiMapper;
        this.comicAppDatabase = comicAppDatabase;
        this.episodeDbMapper = episodeDbMapper;
        this.searchService = searchService;
        this.searchApiMapper = searchApiMapper;
    }

    public Flowable<List<Episode>> getTopTenEpisodes() {
        return trendingService.getTopTrendingEpisodes(API_KEY, NUMBER_OF_EPISODES)
                              .map(apiTrendingEpisodes -> {
                                  final List<ApiEpisode> apiEpisodes = getRandomTen(apiTrendingEpisodes.episodes);
                                  final List<Episode> episodes = episodeApiMapper.toEpisodes(apiEpisodes);
                                  final List<DbEpisode> dbEpisodes = episodeDbMapper.toDbEpisodes(episodes);

                                  comicAppDatabase.episodeDao().insertEpisode(dbEpisodes.toArray(new DbEpisode[dbEpisodes.size()]));
                                  return episodeDbMapper.toEpisodes(comicAppDatabase.episodeDao().getAllEpisodes());
                              });
    }

    @Override
    public Flowable<Episode> getEpisodeDetails(final String episodeId) {
        return comicAppDatabase.episodeDao()
                               .getEpisode(episodeId)
                               .map(episodeDbMapper::toEpisode);
    }

    @Override
    public Completable updateDbEpisode(final String episodeId, final boolean favorite) {
        return Completable.fromAction(() -> comicAppDatabase.episodeDao().updateEpisode(episodeId, favorite));
    }

    @Override
    public Flowable<List<SearchViewModel>> getSearchResults(final String query) {
        return searchService.getTopTrendingEpisodes(API_KEY, query)
                            .map(searchApiMapper::getSearchViewModels);
    }

    private List<ApiEpisode> getRandomTen(final List<ApiEpisode> apiEpisodes) {
        List<ApiEpisode> randomTenApiEpisodes = new ArrayList<>(apiEpisodes);
        Collections.shuffle(randomTenApiEpisodes);
        return randomTenApiEpisodes.subList(FIRST_INDEX_OF_RANDOM_SUBLIST, LAST_INDEX_OF_RANDOM_SUBLIST);
    }
}
