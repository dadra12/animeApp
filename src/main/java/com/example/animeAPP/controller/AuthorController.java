package com.example.animeAPP.controller;


import com.example.animeAPP.domain.dto.ErrorMessage;
import com.example.animeAPP.domain.dto.ListResult;
import com.example.animeAPP.domain.model.projections.ProjectionAuthor;
import com.example.animeAPP.domain.model.projections.ProjectionAuthorDetails;
import com.example.animeAPP.repository.AuthorRepository;
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
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorRepository AuthorRepository;

    @GetMapping("/")
    public ResponseEntity<?> getAllAuthor() {
        List<ProjectionAuthor> authorList = AuthorRepository.findBy();
        return ResponseEntity.ok().body(ListResult.list(authorList));

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthor(@PathVariable UUID id) {
        ProjectionAuthorDetails author = AuthorRepository.findByAuthorid(id, ProjectionAuthorDetails.class);
        if (author != null) {
            return ResponseEntity.ok().body(author);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage.message(String.format("No s 'ha trobat l' author amd id %s", id)));
    }

}
