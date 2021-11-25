package com.example.animeAPP.repository;

import com.example.animeAPP.domain.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimeRepository extends JpaRepository<Anime, UUID> {

    Anime findByname(String name);
}
