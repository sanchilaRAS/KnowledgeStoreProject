package com.spring.backend.repository;

import com.spring.backend.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Notes,Long> {
}
