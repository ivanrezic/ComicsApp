package hr.from.ivanrezic.comicsapp.ui.search;

import java.util.List;

import hr.from.ivanrezic.comicsapp.domain.usecases.FetchSearchResultsUseCase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class SearchPresenter implements SearchContract.Presenter {

    private final SearchContract.View searchFragment;
    private final FetchSearchResultsUseCase fetchSearchResultsUseCase;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public SearchPresenter(final SearchContract.View searchFragment, final FetchSearchResultsUseCase fetchSearchResultsUseCase) {
        this.searchFragment = searchFragment;
        this.fetchSearchResultsUseCase = fetchSearchResultsUseCase;
    }

    @Override
    public void search(final String string) {
        compositeDisposable.add(fetchSearchResultsUseCase.execute(string)
                                                         .subscribeOn(Schedulers.io())
                                                         .observeOn(AndroidSchedulers.mainThread())
                                                         .subscribe(this::onSearchResultFetch, this::onSearchResultError));
    }

    @Override
    public void clear() {
        compositeDisposable.clear();
    }

    private void onSearchResultFetch(List<SearchViewModel> searchViewModels) {
        searchFragment.render(searchViewModels);
    }

    private void onSearchResultError(Throwable throwable) {
        throwable.printStackTrace();
    }
}
