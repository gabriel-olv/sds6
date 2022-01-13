package com.devsuperior.sdsdsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.sdsdsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
