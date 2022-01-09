package com.spring.backend.repository;

import com.spring.backend.entity.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectsRepository extends JpaRepository<Subjects, Long> {
}
