package com.example.animeAPP.repository;

import com.example.animeAPP.domain.model.Genre;
import com.example.animeAPP.domain.model.projections.ProjectionGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID> {

    List<ProjectionGenre>findBy();
    ProjectionGenre findByGenreid(UUID id);
}