package com.konew.musicapp.repository;

import com.konew.musicapp.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long>
{
    @Query(value = "SELECT DISTINCT t.* from tracks as t inner join user_tracks as ut " +
            "on t.id=ut.track_id inner join users as u on ut.user_id=:user_id", nativeQuery = true)
    List<Track> findUserSavedTracks(@Param("user_id") long user_id);

    @Query(value = "SELECT * from tracks where deezer_id=:deezer_id", nativeQuery = true)
    Optional<Track> ifTrackExist(@Param("deezer_id") long deezer_id);
}
