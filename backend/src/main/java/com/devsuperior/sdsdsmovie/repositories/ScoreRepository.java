package com.devsuperior.sdsdsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.sdsdsmovie.entities.Score;
import com.devsuperior.sdsdsmovie.entities.ScorePk;

public interface ScoreRepository extends JpaRepository<Score, ScorePk> {
}
