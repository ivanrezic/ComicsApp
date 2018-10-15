package hr.from.ivanrezic.comicsapp.ui.trending;

import java.util.List;

import hr.from.ivanrezic.comicsapp.ui.details.EpisodeViewModel;

public final class TrendingViewModel {

    public final List<EpisodeViewModel> viewModelList;

    public TrendingViewModel(final List<EpisodeViewModel> viewModelList) {this.viewModelList = viewModelList;}
}
