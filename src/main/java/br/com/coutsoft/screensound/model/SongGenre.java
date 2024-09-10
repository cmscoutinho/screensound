package br.com.coutsoft.screensound.model;

public enum SongGenre {
    ROCK("rock"),
    MPB("mpb"),
    COUNTRY("sertanejo") ,
    PAGODE("pagode"), 
    POP("pop");

    private String songGenre;

    SongGenre(String songGenre) {
        this.songGenre = songGenre;
    }

    public static SongGenre fromString(String text) {
        for (SongGenre songGenre : SongGenre.values()) {
            if (songGenre.songGenre.equalsIgnoreCase(text)) {
                return songGenre;
            }
        }
        throw new EnumConstantNotPresentException(SongGenre.class, text);
    }
}
