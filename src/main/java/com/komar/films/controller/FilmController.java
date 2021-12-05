package com.komar.films.controller;

import com.komar.films.dto.FilmDTO;
import com.komar.films.exception.FilmException;
import com.komar.films.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
	private final FilmService filmService;

	@Autowired
	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}

	@GetMapping("/get/{id}")
	public FilmDTO getFilm(@PathVariable Long id) throws FilmException {
		return filmService.getFilm(id);
	}

	@GetMapping("/get")
	public List<FilmDTO> getFilms() {
		return filmService.getFilms();
	}

	@PostMapping("/create")
	public FilmDTO createFilm(@RequestBody @Valid FilmDTO filmDTO) throws FilmException {
		return filmService.createFilm(filmDTO);
	}

	@PutMapping("/update")
	public FilmDTO updateFilm(@RequestBody @Valid FilmDTO filmDTO) throws FilmException {
		return filmService.updateFilm(filmDTO);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteFilm(@PathVariable Long id) {
		filmService.deleteFilm(id);
	}
}
