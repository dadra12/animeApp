package com.example.animeAPP.controller;

import com.example.animeAPP.domain.dto.ErrorMessage;
import com.example.animeAPP.domain.dto.ListResult;
import com.example.animeAPP.domain.model.projections.ProjectionGenre;
import com.example.animeAPP.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/")
    public ResponseEntity<?> getAllGenre() {
        List<ProjectionGenre> genreList = genreRepository.findBy();
        return ResponseEntity.ok().body(ListResult.list(genreList));

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGenre(@PathVariable UUID id) {
        ProjectionGenre genre = genreRepository.findByGenreid(id);
        if (genre != null) {
            return ResponseEntity.ok().body(genre);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage.message(String.format("No s'ha trobat el genre amd id %s", id)));
    }

}