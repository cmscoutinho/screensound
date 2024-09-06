package br.com.coutsoft.screensound.model;

public enum Genre {
    ROCK("rock"),
    MPB("mpb"),
    COUNTRY("sertanejo") ,
    PAGODE("pagode");

    private String songGenre;

    Genre(String songGenre) {
        this.songGenre = songGenre;
    }
}
