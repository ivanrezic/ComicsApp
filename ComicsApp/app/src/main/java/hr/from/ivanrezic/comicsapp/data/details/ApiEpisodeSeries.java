package hr.from.ivanrezic.comicsapp.data.details;

import com.google.gson.annotations.SerializedName;

public final class ApiEpisodeSeries {

    @SerializedName("name")
    public final String name;

    ApiEpisodeSeries(final String name) {
        this.name = name;
    }
}
