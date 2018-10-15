package hr.from.ivanrezic.comicsapp.data.details;

import com.google.gson.annotations.SerializedName;

public final class ApiEpisodeImage {

    @SerializedName("icon_url")
    public final String iconUrl;

    @SerializedName("small_url")
    public final String smallUrl;

    @SerializedName("medium_url")
    public final String mediumUrl;

    @SerializedName("screen_large_url")
    public final String largeUrl;

    ApiEpisodeImage(final String iconUrl, final String smallUrl, final String mediumUrl, final String largeUrl) {
        this.iconUrl = iconUrl;
        this.smallUrl = smallUrl;
        this.mediumUrl = mediumUrl;
        this.largeUrl = largeUrl;
    }
}
