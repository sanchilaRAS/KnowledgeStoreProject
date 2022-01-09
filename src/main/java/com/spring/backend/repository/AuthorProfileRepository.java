package com.spring.backend.repository;

import com.spring.backend.entity.AuthorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorProfileRepository extends JpaRepository<AuthorProfile,Long> {
}
