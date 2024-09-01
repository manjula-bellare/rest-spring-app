package com.springapp.model;

import jakarta.persistence.*;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    @Lob
    @Column ( length = Integer.MAX_VALUE)
    private byte[] fileData;

    public Profile() {}

    public Profile(String name, String email, byte[] fileData) {
        this.name = name;
        this.email = email;
        this.fileData = fileData;
    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getFileData() { return fileData; }

}
