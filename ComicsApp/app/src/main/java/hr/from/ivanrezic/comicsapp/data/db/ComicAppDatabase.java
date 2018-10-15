package hr.from.ivanrezic.comicsapp.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {DbEpisode.class}, version = 1, exportSchema = false)
public abstract class ComicAppDatabase extends RoomDatabase {

    public abstract EpisodeDao episodeDao();
}
