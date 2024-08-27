package com.heightful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heightful.entity.Profile;
import com.heightful.repository.ProfileRepository;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile createProfile(Long id, String username, String email) {
        Profile profile = new Profile();
        profile.setId(id);
        profile.setUsername(username);
        profile.setEmail(email);
        return profileRepository.save(profile);
    }

    public Profile findProfileById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    public Profile findProfileByUsername(String username) {
        return profileRepository.findByUsername(username).orElse(null);
    }
}
