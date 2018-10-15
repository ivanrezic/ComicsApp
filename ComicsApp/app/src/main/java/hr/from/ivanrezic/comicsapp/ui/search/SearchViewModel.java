package hr.from.ivanrezic.comicsapp.ui.search;

public class SearchViewModel {

    public final String name;

    public final String startYear;

    public final String imageUrl;

    public SearchViewModel(final String name, final String startYear, final String imageUrl) {
        this.name = name;
        this.startYear = startYear;
        this.imageUrl = imageUrl;
    }
}
