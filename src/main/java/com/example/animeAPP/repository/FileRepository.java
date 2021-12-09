package com.example.animeAPP.repository;

import com.example.animeAPP.domain.dto.FileResult;
import com.example.animeAPP.domain.model.File;
import com.example.animeAPP.domain.model.projections.ProjectionFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface FileRepository extends JpaRepository<File, UUID> {

    List<ProjectionFile> findBy();


}
