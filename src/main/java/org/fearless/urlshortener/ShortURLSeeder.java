package org.fearless.urlshortener;

import org.fearless.urlshortener.ShortURL;

import java.net.URI;
import java.util.Arrays;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ShortURLSeeder implements ApplicationRunner {

    private final Logger logger = LoggerFactory.getLogger(ShortURLSeeder.class);

    @Autowired
    private ShortURLRepository shortURLRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        shortURLRepository.deleteAll();

        ShortURL google = new ShortURL(new URI("google.com"), "ggl");
        ShortURL reddit = new ShortURL(new URI("reddit.com"), "rddt");

        shortURLRepository.save(google);
        shortURLRepository.save(reddit);

        for (ShortURL shortURL : shortURLRepository.findAll()) {
            logger.info(shortURL.toString());
        }
    }
}