package com.spring.backend.service;

import com.spring.backend.entity.Species;
import com.spring.backend.entity.User;
import com.spring.backend.repository.SpeciesRepository;
import com.spring.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    public List<User> getALlUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById((userId));
        if(optionalUser.isPresent()) {
            return  optionalUser.get();
        }
        return null;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

//    public User createspecies(User user) {
//        species species = speciesRepository.findById(user.getspeciess().get().getId()).orElse(null);
//    }

}
