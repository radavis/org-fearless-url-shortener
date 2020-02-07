package org.fearless.urlshortener;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

@Controller
public class ShortURLController {

    private final ShortURLService shortURLService;

    @Autowired
    public ShortURLController(ShortURLService shortURLService) {
        this.shortURLService = shortURLService;
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity redirectToURL(@PathVariable("shortCode") String shortCode) {
        ShortURL shortURL;
        try {
            shortURL = shortURLService.expandShortCode(shortCode);
        } catch (ShortCodeNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.FOUND)
            .location(shortURL.getUri())
            .build();
    }

    @PostMapping("/")
    public ResponseEntity shortenURL(@RequestParam URI uri) {
        ShortURL shortURL = shortURLService.shortenURL(uri);
        URI shortenedURL = URI.create("http://localhost:8080/" + shortURL.getShortCode());
        return ResponseEntity.created(shortenedURL).build();
    }
}