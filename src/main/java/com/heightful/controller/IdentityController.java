package com.heightful.controller;

import com.heightful.entity.Profile;
import com.heightful.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/identity")
public class IdentityController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/user/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        Profile profile = profileService.findProfileById(id);
        if (profile != null) {
            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<Profile> getProfileByUsername(@PathVariable String username) {
        Profile profile = profileService.findProfileByUsername(username);
        if (profile != null) {
            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
