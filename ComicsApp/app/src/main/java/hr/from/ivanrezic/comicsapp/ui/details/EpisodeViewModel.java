package hr.from.ivanrezic.comicsapp.ui.details;

public final class EpisodeViewModel {

    public final String episodeNumber;

    public final String name;

    public final String airDate;

    public final String description;

    public final String imageUrl;

    public final String seriesName;

    public final String episodeId;

    public final boolean favorite;

    public EpisodeViewModel(final String episodeNumber,
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
}
