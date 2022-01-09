package com.spring.backend.service;

import com.spring.backend.entity.Subjects;
import com.spring.backend.repository.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectsService {

    @Autowired
    private SubjectsRepository subjectsRepository;

    public List<Subjects> getAllSubjects() {
        return subjectsRepository.findAll();
    }

    public Subjects createSubjects(Subjects subjects) {
        return subjectsRepository.save(subjects);
    }

    public Subjects updateSubjects(Subjects subjects) {
        return subjectsRepository.save(subjects);
    }

    public void deleteSubjects(Long subjectId) {
        subjectsRepository.deleteById(subjectId);
    }
}
