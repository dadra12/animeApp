package com.example.animeAPP.repository;

import com.example.animeAPP.domain.model.Anime;
import com.example.animeAPP.domain.model.projections.ProjectionAnime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AnimeRepository extends JpaRepository<Anime, UUID> {

    Anime findByname(String name);
    List<ProjectionAnime>findBy();
    ProjectionAnime findByAnimeid(UUID id);
}
