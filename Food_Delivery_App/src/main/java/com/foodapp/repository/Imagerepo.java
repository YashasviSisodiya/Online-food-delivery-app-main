package com.foodapp.repository;

import com.foodapp.model.image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Imagerepo extends JpaRepository<image, Long> {
    Optional<image> findByName(String name);
}
