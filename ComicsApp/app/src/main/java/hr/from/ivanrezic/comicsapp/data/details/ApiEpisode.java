package hr.from.ivanrezic.comicsapp.data.details;

import com.google.gson.annotations.SerializedName;

public final class ApiEpisode {

    @SerializedName("episode_number")
    public final String episodeNumber;

    @SerializedName("name")
    public final String name;

    @SerializedName("air_date")
    public final String airDate;

    @SerializedName("description")
    public final String description;

    @SerializedName("api_detail_url")
    public final String episodeDetailsUrl;

    @SerializedName("image")
    public final ApiEpisodeImage imageUrls;

    @SerializedName("series")
    public final ApiEpisodeSeries series;

    public ApiEpisode(final String episodeNumber,
                      final String name,
                      final String air_date,
                      final String description,
                      final String episodeDetailsUrl,
                      final ApiEpisodeImage imageUrls,
                      final ApiEpisodeSeries series) {
        this.episodeNumber = episodeNumber;
        this.name = name;
        this.airDate = air_date;
        this.description = description;
        this.episodeDetailsUrl = episodeDetailsUrl;
        this.imageUrls = imageUrls;
        this.series = series;
    }
}
