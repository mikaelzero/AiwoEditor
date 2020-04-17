package net.mikael.aiworicheditor;

public enum MediaType {
    IMAGE, VIDEO;

    public static MediaType fromString(String value) {
        if (value != null) {
            for (MediaType mediaType : MediaType.values()) {
                if (value.equalsIgnoreCase(mediaType.toString())) {
                    return mediaType;
                }
            }
        }
        return null;
    }
}