package com.devsuperior.sdsdsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.sdsdsmovie.dto.MovieDTO;
import com.devsuperior.sdsdsmovie.dto.ScoreDTO;
import com.devsuperior.sdsdsmovie.entities.Movie;
import com.devsuperior.sdsdsmovie.entities.Score;
import com.devsuperior.sdsdsmovie.entities.User;
import com.devsuperior.sdsdsmovie.repositories.MovieRepository;
import com.devsuperior.sdsdsmovie.repositories.ScoreRepository;
import com.devsuperior.sdsdsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		
		if (user == null) {
			user = new User(null, dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).orElse(null);
		
		if (movie != null) {
			Score score = new Score(movie, user, dto.getScore());
			score = scoreRepository.saveAndFlush(score);
			
			movie = updateMovieScore(movie);
			movie = movieRepository.save(movie);
			return new MovieDTO(movie);
		}
		return null;
	}

	private Movie updateMovieScore(Movie movie) {
		double scoreSum = 0.0;
		for(Score s : movie.getScores()) {
			scoreSum += s.getValue();
		}
		
		int count = movie.getScores().size();
		double average = scoreSum / count;
		movie.setScore(average);
		movie.setCount(count);
		
		return movie;
	}
}
