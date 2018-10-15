package hr.from.ivanrezic.comicsapp.di.application.modules;

import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hr.from.ivanrezic.comicsapp.data.db.ComicAppDatabase;
import hr.from.ivanrezic.comicsapp.data.mappers.EpisodeApiMapper;
import hr.from.ivanrezic.comicsapp.data.mappers.EpisodeDbMapper;
import hr.from.ivanrezic.comicsapp.data.mappers.SearchApiMapper;
import hr.from.ivanrezic.comicsapp.data.repository.EpisodeRepositoryImpl;
import hr.from.ivanrezic.comicsapp.data.search.SearchService;
import hr.from.ivanrezic.comicsapp.data.trending.TrendingService;
import hr.from.ivanrezic.comicsapp.di.application.ComicsAppApplication;
import hr.from.ivanrezic.comicsapp.domain.EpisodeRepository;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public final class DataModule {

    private static final String BASE_URL = "https://comicvine.gamespot.com/api/";
    private static final String DATABASE_NAME = "Comic App Database";

    private final ComicsAppApplication comicsAppApplication;

    public DataModule(final ComicsAppApplication comicsAppApplication) {
        this.comicsAppApplication = comicsAppApplication;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                                     .addConverterFactory(GsonConverterFactory.create())
                                     .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                     .build();
    }

    @Provides
    @Singleton
    public TrendingService provideTrendingService(final Retrofit retrofit) {
        return retrofit.create(TrendingService.class);
    }

    @Provides
    @Singleton
    public SearchService provideSearchService(final Retrofit retrofit) {
        return retrofit.create(SearchService.class);
    }

    @Provides
    @Singleton
    public EpisodeApiMapper provideEpisodeApiMapper() {
        return new EpisodeApiMapper();
    }

    @Provides
    @Singleton
    public ComicAppDatabase provideComicAppDatabase() {
        return Room.inMemoryDatabaseBuilder(comicsAppApplication, ComicAppDatabase.class).fallbackToDestructiveMigration().build();
    }

    @Provides
    @Singleton
    public EpisodeDbMapper provideEpisodeEntityMapper() {
        return new EpisodeDbMapper();
    }

    @Provides
    @Singleton
    public SearchApiMapper provideSearchApiMapper() {
        return new SearchApiMapper();
    }

    @Provides
    @Singleton
    public EpisodeRepository provideEpisodeRepository(final TrendingService trendingService,
                                                      final EpisodeApiMapper episodeApiMapper,
                                                      final ComicAppDatabase comicAppDatabase,
                                                      final EpisodeDbMapper episodeDbMapper,
                                                      final SearchService searchService,
                                                      final SearchApiMapper searchApiMapper) {
        return new EpisodeRepositoryImpl(trendingService,
                                         searchService,
                                         episodeApiMapper,
                                         comicAppDatabase,
                                         episodeDbMapper,
                                         searchApiMapper);
    }
}
