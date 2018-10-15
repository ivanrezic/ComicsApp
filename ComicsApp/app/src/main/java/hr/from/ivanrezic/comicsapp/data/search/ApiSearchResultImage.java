package hr.from.ivanrezic.comicsapp.data.search;

import com.google.gson.annotations.SerializedName;

public class ApiSearchResultImage {

    @SerializedName("screen_large_url")
    public final String screenLargeUrl;

    ApiSearchResultImage(final String screenLargeUrl) {
        this.screenLargeUrl = screenLargeUrl;
    }
}
