package hr.from.ivanrezic.comicsapp.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import hr.from.ivanrezic.comicsapp.domain.Episode;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;

@Dao
public interface EpisodeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertEpisode(final DbEpisode... dbEpisode);

    @Query("SELECT * FROM episodes WHERE episodeID = :episodeID")
    Flowable<DbEpisode> getEpisode(String episodeID);

    @Query("UPDATE episodes SET favorite = :favorite WHERE episodeId = :episodeId")
    void updateEpisode(final String episodeId, final boolean favorite);

    @Query("SELECT * FROM episodes")
    List<DbEpisode> getAllEpisodes();
}
