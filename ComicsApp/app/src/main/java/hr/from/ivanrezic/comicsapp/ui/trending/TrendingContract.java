package hr.from.ivanrezic.comicsapp.ui.trending;

public interface TrendingContract {

    interface View {

        void render(TrendingViewModel trendingViewModel);
    }

    interface Presenter {

        void start();

        void refresh();

        void clickFavorite(String episodeId, final boolean favorite);

        void clear();
    }
}
