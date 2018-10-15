package hr.from.ivanrezic.comicsapp.data.search;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiSearch {

    @SerializedName("results")
    public final List<ApiSearchResult> results;

    public ApiSearch(final List<ApiSearchResult> results) {
        this.results = results;
    }
}
