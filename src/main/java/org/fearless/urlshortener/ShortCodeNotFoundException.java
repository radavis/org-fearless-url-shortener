package org.fearless.urlshortener;

import lombok.Getter;

public class ShortCodeNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @Getter
    private final String shortCode;

    public ShortCodeNotFoundException(final String shortCode) {
        super(String.format("Could not find ShortURL for [%s]", shortCode));
        this.shortCode = shortCode;
    }
}