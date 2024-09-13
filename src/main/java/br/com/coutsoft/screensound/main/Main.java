package br.com.coutsoft.screensound.main;

import br.com.coutsoft.screensound.exception.ArtistExistsException;
import br.com.coutsoft.screensound.exception.ArtistNotFoundException;
import br.com.coutsoft.screensound.model.Artist;
import br.com.coutsoft.screensound.model.ArtistType;
import br.com.coutsoft.screensound.model.Song;
import br.com.coutsoft.screensound.model.SongGenre;
import br.com.coutsoft.screensound.repository.ArtistRepository;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);

    private ArtistRepository artistRepository;
    private Optional<Artist> artistOpt;

    public Main(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public void showMenu() {

        int option;

        do {

            System.out.println("""
                    Welcome to Screensound!
                    Choose an option:
                                    
                    1-Register artist
                    2-Register song
                    3-List songs
                    4-Search song by artist
                    5-Look for info about artist
                    9-Exit""");

            option = scanner.nextInt();
            scanner.nextLine();

            // TODO: use println() to display e.getMessage();
            switch (option) {
                case 1:
                    try {
                        registerArtist();
                    } catch (ArtistExistsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        registerSong();
                    } catch (ArtistNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    listSongs();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    break;
            }
        } while (option != 9);

    }

    private Optional<Artist> searchArtist(String name) {
        Optional<Artist> artistOpt = artistRepository.findByNameIgnoreCase(name);
        return artistOpt;
    }

    private void registerArtist() {
        String registerNew;

        do {
            System.out.print("Artist's name: ");
            var name = scanner.nextLine();

            if (searchArtist(name).isPresent()) {
                throw new ArtistExistsException();
            } else {

                System.out.print("Artist type (solo, duo, band): ");
                var type = scanner.nextLine();

                System.out.print("Register another artist? (Y/N): ");
                registerNew = scanner.nextLine();

                artistRepository.save(new Artist(name, ArtistType.fromString(type)));
            }
        } while (registerNew.equalsIgnoreCase("Y"));

    }

    private void registerSong() {
        String registerNew;

        do {
            Artist artist;

            System.out.print("Song's title: ");
            var title = scanner.nextLine();

            System.out.print("Artist: ");
            var artistName = scanner.nextLine();

            artistOpt = searchArtist(artistName);
            if (artistOpt.isPresent()) {
                artist = artistOpt.get();
            } else {
                throw new ArtistNotFoundException();
            }

            System.out.print("Song's album: ");
            var album = scanner.nextLine();

            System.out.print("Song's genre (rock, mpb, country, pagode, pop): ");
            var genre = scanner.nextLine().toLowerCase();

            System.out.print("Register another song? (Y/N): ");
            registerNew = scanner.nextLine();

            Song song = new Song(title, artist, album, SongGenre.fromString(genre));
            artist.addSong(song);

            artistRepository.save(artist);
            //songRepository.save(song);

        } while (registerNew.equalsIgnoreCase("Y"));

    }

    private void listSongs() {

    }
}
