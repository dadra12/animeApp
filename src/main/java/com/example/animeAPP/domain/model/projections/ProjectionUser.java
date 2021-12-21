package com.example.animeAPP.domain.model.projections;

import com.example.animeAPP.domain.model.Favorite;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Set;
import java.util.UUID;

@JsonPropertyOrder({"userid", "username"})
public interface ProjectionUser {

    UUID getUserid();
    String getUsername();

    @JsonIgnoreProperties("favoriteby")
    Set<ProjectionFavorite> getFavorites();

}