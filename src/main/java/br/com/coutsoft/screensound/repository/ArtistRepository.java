package br.com.coutsoft.screensound.repository;

import br.com.coutsoft.screensound.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
