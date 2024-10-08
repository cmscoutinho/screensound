package br.com.coutsoft.screensound.main;

import br.com.coutsoft.screensound.exception.ArtistExistsException;
import br.com.coutsoft.screensound.exception.ArtistNotFoundException;
import br.com.coutsoft.screensound.model.*;
import br.com.coutsoft.screensound.repository.ArtistRepository;
import br.com.coutsoft.screensound.repository.SongRepository;
import br.com.coutsoft.screensound.services.CohereConnector;
import br.com.coutsoft.screensound.services.DataConverter;
import br.com.coutsoft.screensound.services.translation.MyMemoryAPIQuery;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);
    private DataConverter converter = new DataConverter();

    private ArtistRepository artistRepository;
    private SongRepository songRepository;
    private Optional<Artist> artistOpt;

    public Main(ArtistRepository artistRepository, SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
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

            switch (option) {
                case 1:
                    try {
                        registerArtist();
                    } catch (ArtistExistsException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        registerSong();
                    } catch (ArtistNotFoundException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    listSongs();
                    break;
                case 4:
                    try {
                        songByArtist();
                    } catch (ArtistNotFoundException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    infoAboutArtist();
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.err.println("Invalid option!");
            }
        } while (option != 9);

    }

    private String capitalizeName(String name) {
        String[] nameArr = name.split(" ");
        StringBuilder builder = new StringBuilder();

        for (String nameIt : nameArr) {
            builder.append(nameIt.substring(0, 1).toUpperCase()).append(nameIt.substring(1).toLowerCase()).append(" ");
        }

        return builder.toString().trim();
    }

    private String readArtist() {
        System.out.print("Artist's name: ");
        return capitalizeName(scanner.nextLine());
    }

    private Optional<Artist> searchArtist(String artistName) {
        Optional<Artist> artistOpt = artistRepository.findByNameIgnoreCase(artistName);
        return artistOpt;
    }

    private void registerArtist() {
        String registerNew;

        var artistName = readArtist();
        artistOpt = searchArtist(artistName);
        do {

            if (artistOpt.isPresent()) {
                throw new ArtistExistsException();
            } else {

                System.out.print("Artist type (solo, duo, band): ");
                var type = scanner.nextLine();

                System.out.print("Register another artist? (Y/N): ");
                registerNew = scanner.nextLine();

                artistRepository.save(new Artist(capitalizeName(artistName), ArtistType.fromString(type)));
            }
        } while (registerNew.equalsIgnoreCase("Y"));

    }

    private void registerSong() {
        String registerNew;

        do {
            Artist artist;

            System.out.print("Song's title: ");
            var title = capitalizeName(scanner.nextLine());

            var artistName = readArtist();
            artistOpt = searchArtist(artistName);

            if (artistOpt.isPresent()) {
                artist = artistOpt.get();
            } else {
                throw new ArtistNotFoundException();
            }

            System.out.print("Song's album: ");
            var album = capitalizeName(scanner.nextLine());

            System.out.print("Song's genre (rock, mpb, country, pagode, pop): ");
            var genre = scanner.nextLine().toLowerCase();

            System.out.print("Register another song? (Y/N): ");
            registerNew = scanner.nextLine();

            Song song = new Song(capitalizeName(title), artist, album, SongGenre.fromString(genre));
            artist.addSong(song);

            artistRepository.save(artist);
            //songRepository.save(song);

        } while (registerNew.equalsIgnoreCase("Y"));

    }

    private void listSongs() {
        List<Song> allSongs = songRepository.findAll();
        allSongs.forEach(System.out::println);
    }

    private void songByArtist() {
        List<Song> songsByArtist;

        var artistName = readArtist();
        artistOpt = searchArtist(artistName);
        if (artistOpt.isPresent()) {
            //songsByArtist = songRepository.findAllByArtistName(artistOpt.get().getName());
            songsByArtist = songRepository.findSongsByArtist(artistOpt.get().getName());
            songsByArtist.forEach(System.out::println);
        } else {
            throw new ArtistNotFoundException();
        }

    }

    private void infoAboutArtist() {
        String json = CohereConnector.cohereConnect(readArtist());
        CohereMessage message = converter.convertJson(json, CohereMessage.class);
        String translation = MyMemoryAPIQuery.translate(message.text());
        System.out.println(translation);
    }
}
