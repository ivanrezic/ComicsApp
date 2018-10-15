package hr.from.ivanrezic.comicsapp.domain;

import java.util.Objects;

public final class Episode {

    public final String episodeNumber;

    public final String name;

    public final String airDate;

    public final String description;

    public final String imageUrl;

    public final String seriesName;

    public final String episodeId;

    public final boolean favorite;

    public Episode(final String episodeNumber,
                   final String name,
                   final String airDate,
                   final String description,
                   final String imageUrl,
                   final String seriesName,
                   final String episodeId,
                   final boolean favorite) {
        this.episodeNumber = episodeNumber;
        this.name = name;
        this.airDate = airDate;
        this.description = description;
        this.imageUrl = imageUrl;
        this.seriesName = seriesName;
        this.episodeId = episodeId;
        this.favorite = favorite;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Episode episode = (Episode) o;
        return favorite == episode.favorite &&
                Objects.equals(episodeNumber, episode.episodeNumber) &&
                Objects.equals(name, episode.name) &&
                Objects.equals(airDate, episode.airDate) &&
                Objects.equals(description, episode.description) &&
                Objects.equals(imageUrl, episode.imageUrl) &&
                Objects.equals(seriesName, episode.seriesName) &&
                Objects.equals(episodeId, episode.episodeId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(episodeNumber, name, airDate, description, imageUrl, seriesName, episodeId, favorite);
    }
}
