package hr.from.ivanrezic.comicsapp.data.search;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchService {

    @GET("search/?format=json")
    Flowable<ApiSearch> getTopTrendingEpisodes(@Query("api_key") String apiKey, @Query("query") String query);
}
