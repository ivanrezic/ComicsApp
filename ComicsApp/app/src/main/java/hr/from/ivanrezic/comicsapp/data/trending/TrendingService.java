package hr.from.ivanrezic.comicsapp.data.trending;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TrendingService {

    @GET("episodes/?format=json")
    Flowable<ApiTrendingEpisodes> getTopTrendingEpisodes(@Query("api_key") String apiKey, @Query("limit") int numberOfEpisodes);
}
