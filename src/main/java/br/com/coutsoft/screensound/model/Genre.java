package br.com.coutsoft.screensound.model;

public enum Genre {
    ROCK("rock"),
    MPB("mpb"),
    COUNTRY("sertanejo") ,
    PAGODE("pagode"), 
    POP("pop");

    private String songGenre;

    Genre(String songGenre) {
        this.songGenre = songGenre;
    }

    public static Genre fromString(String text) {
        for (Genre genre : Genre.values()) {
            if (genre.songGenre.equalsIgnoreCase(text)) {
                return genre;
            }
        }
        throw new EnumConstantNotPresentException(Genre.class, text);
    }
}
