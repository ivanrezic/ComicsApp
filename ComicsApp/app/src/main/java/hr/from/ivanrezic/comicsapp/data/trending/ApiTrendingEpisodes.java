package hr.from.ivanrezic.comicsapp.data.trending;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import hr.from.ivanrezic.comicsapp.data.details.ApiEpisode;

public final class ApiTrendingEpisodes {

    @SerializedName("number_of_page_results")
    public final int numberOfTotalResults;

    @SerializedName("results")
    public final List<ApiEpisode> episodes;

    public ApiTrendingEpisodes(final int numberOfTotalResults, final List<ApiEpisode> episodes) {
        this.numberOfTotalResults = numberOfTotalResults;
        this.episodes = episodes;
    }
}
