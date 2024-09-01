package com.springapp.model;

import org.springframework.hateoas.RepresentationModel;

public class FileResource extends RepresentationModel<FileResource> {
    private String fileType;
    private long size;
    private String name;

    public FileResource(String name, String fileType, long size) {
        this.fileType = fileType;
        this.size = size;
        this.name = name;
    }
    public String getFileType() {
        return fileType;
    }

    public long getSize() {
        return size;
    }

    public String getName() {
        return name;
    }


}
