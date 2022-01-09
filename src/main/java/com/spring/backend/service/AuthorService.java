package com.spring.backend.service;

import com.spring.backend.entity.Notes;
import com.spring.backend.entity.Author;
import com.spring.backend.repository.NotesRepository;
import com.spring.backend.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private NotesRepository notesRepository;

    public List<Author> getALlAuthor() {
        return authorRepository.findAll();
    }

    public Author getAuthor(Long authorId) {
        Optional<Author> optionalAuthor = authorRepository.findById((authorId));
        if(optionalAuthor.isPresent()) {
            return  optionalAuthor.get();
        }
        return null;
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }


}
