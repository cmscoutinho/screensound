package br.com.coutsoft.screensound.model;

public enum ArtistType {

    SOLO("solo"), DUO("duo"), BAND("band");

    private String artistType;

    ArtistType(String artistType) {
        this.artistType = artistType;
    }

    public static ArtistType fromString(String artistType) {
        for (ArtistType type : ArtistType.values()) {
            if (type.artistType.equalsIgnoreCase(artistType)) {
                return type;
            }
        }

        throw new EnumConstantNotPresentException(ArtistType.class, "Artist type not found!");
    }
}
