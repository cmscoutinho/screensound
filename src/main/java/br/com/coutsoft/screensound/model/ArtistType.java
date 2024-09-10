package br.com.coutsoft.screensound.model;

public enum ArtistType {

    SOLO("solo"),
    DUO("duo"),
    BAND("band");

    private String artistType;

    ArtistType(String artistType) {
        this.artistType = artistType;
    }
}
