package com.springapp.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.springapp.model.Profile;
import com.springapp.model.ProfileRepository;
import com.springapp.model.FileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@RestController
public class FileController {
    @Autowired
    ProfileRepository profileRepository;
    @PostMapping(value= "/api/resources/upload", consumes= MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<FileResource> uploadFile(@RequestParam("name") MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        FileResource fileResource = new FileResource(fileName, file.getContentType(), file.getSize());
        fileResource.add(linkTo(methodOn(FileController.class).uploadFile(file)).withSelfRel());

        Profile profile = new Profile("Api_Learner", "learner@learnApi.com", file.getBytes());
        profileRepository.save(profile);

        return new ResponseEntity<>(fileResource, HttpStatus.OK);

    }

    @GetMapping(value = "/api/resources/user")
    public HttpEntity<Profile> userProfile(@RequestParam("id") Integer id) {
       Optional<Profile> profile = profileRepository.findById(id);

       return new ResponseEntity<>(profile.orElse(null), HttpStatus.OK);
    }
}
