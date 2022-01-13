package com.devsuperior.sdsdsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.sdsdsmovie.dto.MovieDTO;
import com.devsuperior.sdsdsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		return movieRepository.findAll(pageable)
				.map(obj -> new MovieDTO(obj));
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		if (id == null) return null;
		
		return movieRepository.findById(id)
				.map(obj -> new MovieDTO(obj))
				.orElse(null);
	}
}
