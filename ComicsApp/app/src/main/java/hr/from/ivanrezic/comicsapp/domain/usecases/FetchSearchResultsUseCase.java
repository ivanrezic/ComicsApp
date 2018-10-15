package hr.from.ivanrezic.comicsapp.domain.usecases;

import java.util.List;

import hr.from.ivanrezic.comicsapp.domain.EpisodeRepository;
import hr.from.ivanrezic.comicsapp.ui.search.SearchViewModel;
import io.reactivex.Flowable;

public class FetchSearchResultsUseCase implements FlowableUseCaseWithParameter<List<SearchViewModel>, String> {

    private final EpisodeRepository episodeRepository;

    public FetchSearchResultsUseCase(final EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public Flowable<List<SearchViewModel>> execute(final String parameter) {
        return episodeRepository.getSearchResults(parameter);
    }
}
