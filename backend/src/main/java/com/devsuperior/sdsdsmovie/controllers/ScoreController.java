package com.devsuperior.sdsdsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.sdsdsmovie.dto.MovieDTO;
import com.devsuperior.sdsdsmovie.dto.ScoreDTO;
import com.devsuperior.sdsdsmovie.services.ScoreService;

@RestController
@RequestMapping("/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;

	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
		return scoreService.saveScore(dto);
	}
}
