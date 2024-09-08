package br.com.coutsoft.screensound.repository;

import br.com.coutsoft.screensound.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional findByNameIgnoreCase(String artistStr);
}
