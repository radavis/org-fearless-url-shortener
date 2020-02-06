package org.fearless.urlshortener;

import java.net.URI;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@ToString
public class ShortURL {

    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private URI uri;

    @Indexed(unique=true)
    @Getter
    @Setter
    private String shortCode;

    @Getter
    @Setter
    private LocalDateTime createdDate;

    public ShortURL(URI uri, String shortCode) {
        this.uri = uri;
        this.shortCode = shortCode;
        this.createdDate = LocalDateTime.now();
    }

}