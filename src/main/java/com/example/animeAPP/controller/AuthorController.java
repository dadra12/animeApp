package com.example.animeAPP.controller;


import com.example.animeAPP.domain.dto.ListResult;
import com.example.animeAPP.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/")
    public ResponseEntity<?> findAllAuthors(Authentication authentication) {
        return ResponseEntity.ok().body(ListResult.list(authorRepository.findAll()));
    }
}
