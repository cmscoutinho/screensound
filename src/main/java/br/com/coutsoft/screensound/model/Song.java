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
    private Integer length;

    @ManyToOne
    private Artist artist;

    public Song() {
    }

    public Song(Long id, String title, Integer length, Artist artist) {
        this.id = id;
        this.title = title;
        this.length = length;
        this.artist = artist;
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

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return this.title + " by " + this.artist + ". Length: " + this.length;
    }
}
