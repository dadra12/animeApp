package com.example.animeAPP.domain.dto;

import com.example.animeAPP.domain.model.File;

import java.util.UUID;

public class FileResult {
    public UUID fileid;
    public String contenttype;


    public FileResult(File file) {
        this.fileid = file.fileid;
        this.contenttype = file.contenttype;
    }

    public FileResult(UUID fileid, String contenttype) {
        this.fileid = fileid;
        this.contenttype = contenttype;
    }

    public static FileResult file(File file) {
        return new FileResult(file);
    }
}
