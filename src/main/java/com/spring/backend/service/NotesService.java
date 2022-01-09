package com.spring.backend.service;

import com.spring.backend.entity.Notes;
import com.spring.backend.entity.Author;
import com.spring.backend.entity.AuthorProfile;
import com.spring.backend.repository.NotesRepository;
import com.spring.backend.repository.AuthorProfileRepository;
//import com.spring.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private AuthorProfileRepository authorProfileRepository;

    public List<Notes> getAllnotes() {
        return notesRepository.findAll();
    }

    public Notes getnotes(Long id) {
        Optional<Notes> optionalnotes = notesRepository.findById(id);
        if(optionalnotes.isPresent()) {
            return optionalnotes.get();
        }
        return null;
    }

    public Notes createnotes(Notes notes) {
        AuthorProfile authorProfile = authorProfileRepository.findById(notes.getAuthorProfile().getId()).orElse(null);
        if(null == authorProfile) {
            authorProfile = new AuthorProfile();
        }
        authorProfile.setId(notes.getAuthorProfile().getId());
        notes.setAuthorProfile(authorProfile);
        return notesRepository.save(notes);
    }

    public Notes updatenotes(Notes notes) {
        return notesRepository.save(notes);
    }

    public void deletenotes(Long notesId) {
        notesRepository.deleteById(notesId);
    }
}
