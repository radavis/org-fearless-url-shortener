package org.fearless.urlshortener;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ShortURLRepository extends CrudRepository<ShortURL, String> {
    public Optional<ShortURL> findByShortCode(String shortCode);
}