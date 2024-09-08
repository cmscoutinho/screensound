package br.com.coutsoft.screensound.exception;

public class ArtistNotFoundException extends RuntimeException {
    public ArtistNotFoundException() {
        super("Artist not found!");
    }
}
