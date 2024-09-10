package br.com.coutsoft.screensound.model;

import jakarta.persistence.*;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    @ManyToOne
    private Artist artist;
    private String album;
    @Enumerated(EnumType.STRING)
    private SongGenre songGenre;


    public Song() {
    }

    public Song(String title, Artist artist, String album, SongGenre songGenre) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.songGenre = songGenre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public SongGenre getGenre() {
        return songGenre;
    }

    public void setGenre(SongGenre songGenre) {
        this.songGenre = songGenre;
    }

    @Override
    public String toString() {
        return this.title + " by " + this.artist + ". " + this.songGenre;
    }
}
