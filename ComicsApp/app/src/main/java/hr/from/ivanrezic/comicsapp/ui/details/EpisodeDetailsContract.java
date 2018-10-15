package hr.from.ivanrezic.comicsapp.ui.details;

public interface EpisodeDetailsContract {

    interface View {

        void render(EpisodeViewModel episodeViewModel);
    }

    interface Presenter {

        void start(String episodeId);

        void clear();
    }
}
