package br.com.coutsoft.screensound.repository;

import br.com.coutsoft.screensound.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    @Query("SELECT s FROM Song s WHERE s.artist.name = :artistName")
    List<Song> findSongsByArtist(String artistName);
    //List<Song> findAllByArtistName(String artistName);
}
