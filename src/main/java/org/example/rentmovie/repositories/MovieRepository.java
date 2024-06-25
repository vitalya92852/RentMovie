package org.example.rentmovie.repositories;

import org.example.rentmovie.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<MovieEntity,Long> {
}
