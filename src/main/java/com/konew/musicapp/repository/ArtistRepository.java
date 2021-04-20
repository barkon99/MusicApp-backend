package com.konew.musicapp.repository;

import com.konew.musicapp.entity.Artist;
import com.konew.musicapp.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>
{

    @Query(value = "SELECT a.* from artists as a inner join user_artists ua " +
            "on a.id=ua.artist_id inner join users as u on ua.user_id = u.id where u.id=:user_id", nativeQuery = true)
    List<Artist> findUserSavedArtists(@Param("user_id") long user_id);

    @Query(value = "SELECT * from artists where deezer_id=:deezer_id", nativeQuery = true)
    Optional<Artist> ifArtistExist(@Param("deezer_id") long deezer_id);
}
