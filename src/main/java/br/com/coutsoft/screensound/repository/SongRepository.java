package br.com.coutsoft.screensound.repository;

import br.com.coutsoft.screensound.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {

}
