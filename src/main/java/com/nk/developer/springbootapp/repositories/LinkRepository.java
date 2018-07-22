package com.nk.developer.springbootapp.repositories;

import com.nk.developer.springbootapp.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}