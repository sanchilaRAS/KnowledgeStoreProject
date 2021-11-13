package com.spring.backend.service;

import com.spring.backend.entity.Species;
import com.spring.backend.entity.User;
import com.spring.backend.entity.UserProfile;
import com.spring.backend.repository.SpeciesRepository;
import com.spring.backend.repository.UserProfileRepository;
//import com.spring.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public List<Species> getAllspeciess() {
        return speciesRepository.findAll();
    }

    public Species getspecies(Long id) {
        Optional<Species> optionalspecies = speciesRepository.findById(id);
        if(optionalspecies.isPresent()) {
            return optionalspecies.get();
        }
        return null;
    }

    public Species createspecies(Species species) {
        UserProfile userProfile = userProfileRepository.findById(species.getUserProfile().getId()).orElse(null);
        if(null == userProfile) {
            userProfile = new UserProfile();
        }
        userProfile.setId(species.getUserProfile().getId());
        species.setUserProfile(userProfile);
        return speciesRepository.save(species);
    }

    public Species updatespecies(Species species) {
        return speciesRepository.save(species);
    }

    public void deletespecies(Long speciesId) {
        speciesRepository.deleteById(speciesId);
    }
}
