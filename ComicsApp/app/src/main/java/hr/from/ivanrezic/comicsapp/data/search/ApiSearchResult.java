package hr.from.ivanrezic.comicsapp.data.search;

import com.google.gson.annotations.SerializedName;

public class ApiSearchResult {

    @SerializedName("name")
    public final String name;

    @SerializedName("start_year")
    public final String startYear;

    @SerializedName("image")
    public final ApiSearchResultImage apiSearchResultImage;

    public ApiSearchResult(final String name, final String startYear, final ApiSearchResultImage apiSearchResultImage) {
        this.name = name;
        this.startYear = startYear;
        this.apiSearchResultImage = apiSearchResultImage;
    }
}
