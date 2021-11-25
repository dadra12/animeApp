package com.example.animeAPP.controller;

import com.example.animeAPP.domain.dto.ErrorMessage;
import com.example.animeAPP.domain.dto.ListResult;
import com.example.animeAPP.domain.model.Anime;
import com.example.animeAPP.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/animes")
public class AnimeController {

    @Autowired
    private AnimeRepository animeRepository;

    @GetMapping("/")
    public ResponseEntity<?> findAllAnimes(Authentication authentication) {
        return ResponseEntity.ok().body(ListResult.list(animeRepository.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAnimeId(@PathVariable UUID id) {
        Anime anime = animeRepository.findById(id).orElse(null);
        if (anime == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ErrorMessage.message("No s'ha trobat l'anime amd id \'" + id + "\'"));
        }

        return ResponseEntity.ok().body(anime);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAnime(@RequestBody Anime anime, Authentication authentication) {
        return ResponseEntity.ok().body(animeRepository.save(anime));
    }
}