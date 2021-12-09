package com.example.animeAPP.domain.model.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;
@JsonPropertyOrder({"fileid", "contenttype"})
public interface ProjectionFile {

    UUID getFileid();
    String getContenttype();

}