package hr.from.ivanrezic.comicsapp.data.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "episodes")
public final class DbEpisode {

    @NonNull
    @PrimaryKey
    private final String episodeId;

    private final String name;

    private final String episodeNumber;

    private final String airDate;

    private final String description;

    private final String imageUrl;

    private final String seriesName;

    private final boolean favorite;

    public DbEpisode(final String episodeNumber, final String name, final String airDate, final String description, final String imageUrl, final String seriesName,
                     final String episodeId, final boolean favorite) {
        this.episodeNumber = episodeNumber;
        this.name = name;
        this.airDate = airDate;
        this.description = description;
        this.imageUrl = imageUrl;
        this.seriesName = seriesName;
        this.episodeId = episodeId;
        this.favorite = favorite;
    }

    public String getEpisodeId() {
        return episodeId;
    }

    public String getName() {
        return name;
    }

    public String getEpisodeNumber() {
        return episodeNumber;
    }

    public String getAirDate() {
        return airDate;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public boolean isFavorite() {
        return favorite;
    }
}
