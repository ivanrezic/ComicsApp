package hr.from.ivanrezic.comicsapp.di.application.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hr.from.ivanrezic.comicsapp.ui.trending.EpisodesViewModelMapper;
import hr.from.ivanrezic.comicsapp.utils.ImageLoader;
import hr.from.ivanrezic.comicsapp.utils.ImageLoaderImpl;

@Module
public final class UtilsModule {

    @Provides
    @Singleton
    public ImageLoader provideImageLoader() {
        return new ImageLoaderImpl();
    }

    @Provides
    @Singleton
    public EpisodesViewModelMapper provideEpisodesViewModelMapper() {
        return new EpisodesViewModelMapper();
    }
}
