package br.com.coutsoft.screensound.exception;

public class ArtistExistsException extends RuntimeException {
    public ArtistExistsException() {
        super("Artist already exists!");
    }
}
