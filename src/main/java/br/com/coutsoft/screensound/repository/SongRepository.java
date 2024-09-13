package br.com.coutsoft.screensound.repository;

import br.com.coutsoft.screensound.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findAllByArtistName(String artistName);
}
