package com.spring.backend.service;

import com.spring.backend.entity.AuthorProfile;
import com.spring.backend.repository.AuthorProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorProfileService {

    @Autowired
    private AuthorProfileRepository authorProfileRepository;

    public List<AuthorProfile> getAllAuthorProfiles() {
        return authorProfileRepository.findAll();
    }

}
