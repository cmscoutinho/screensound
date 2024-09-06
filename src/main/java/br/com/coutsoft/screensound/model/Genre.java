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

    public Genre fromString(String songGenre) {
        for (Genre genre : Genre.values()) {
            if (genre.songGenre.equalsIgnoreCase(songGenre)) {
                return genre;
            }
        }
        throw new EnumConstantNotPresentException(Genre.class, songGenre);
    }
}
