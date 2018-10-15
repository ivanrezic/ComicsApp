package hr.from.ivanrezic.comicsapp.data.mappers;

import com.annimon.stream.Stream;

import java.util.ArrayList;
import java.util.List;

import hr.from.ivanrezic.comicsapp.data.search.ApiSearch;
import hr.from.ivanrezic.comicsapp.ui.search.SearchViewModel;

import static hr.from.ivanrezic.comicsapp.utils.Util.validateProperty;

public final class SearchApiMapper {

    public List<SearchViewModel> getSearchViewModels(ApiSearch apiSearch) {
        final List<SearchViewModel> searchViewModels = new ArrayList<>();
        if (apiSearch.results.isEmpty()) {
            return searchViewModels;
        }

        Stream.of(apiSearch.results).forEach(e -> searchViewModels.add(new SearchViewModel(validateProperty(e.name, "name"),
                                                                                           validateProperty(e.startYear, "start year"),
                                                                                           e.apiSearchResultImage == null ? "" : e.apiSearchResultImage.screenLargeUrl)));

        return searchViewModels;
    }
}
