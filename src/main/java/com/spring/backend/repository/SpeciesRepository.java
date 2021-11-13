package com.spring.backend.repository;

import com.spring.backend.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species,Long> {
}
