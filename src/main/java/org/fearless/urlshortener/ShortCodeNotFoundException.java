package org.fearless.urlshortener;

import lombok.Getter;

public class ShortCodeNotFoundException extends RuntimeException {

    @Getter
    private final String shortCode;

    public ShortCodeNotFoundException(String shortCode) {
        super(String.format("Could not find ShortURL for [%s]", shortCode));
        this.shortCode = shortCode;
    }
}