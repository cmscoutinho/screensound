package br.com.coutsoft.screensound;

import br.com.coutsoft.screensound.main.Main;
import br.com.coutsoft.screensound.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreensoundApplication implements CommandLineRunner {

	@Autowired
	private ArtistRepository artistRepository;

	public static void main(String[] args) {
		SpringApplication.run(ScreensoundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(artistRepository);
		main.showMenu();
	}
}
