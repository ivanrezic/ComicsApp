package hr.from.ivanrezic.comicsapp.ui.search;

import java.util.List;

public interface SearchContract {

    interface View {

        void render(final List<SearchViewModel> searchViewModels);
    }

    interface Presenter {

        void search(final String string);

        void clear();
    }
}
