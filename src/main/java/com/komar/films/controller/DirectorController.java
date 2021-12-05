package com.komar.films.controller;

import com.komar.films.dto.DirectorDTO;
import com.komar.films.exception.FilmException;
import com.komar.films.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/director")
public class DirectorController {
	private final DirectorService directorService;

	@Autowired
	public DirectorController(DirectorService directorService) {
		this.directorService = directorService;
	}

	@GetMapping("/get/{id}")
	public DirectorDTO getDirector(@PathVariable Long id) throws FilmException {
		return directorService.getDirector(id);
	}

	@GetMapping("/get")
	public List<DirectorDTO> getDirectors() {
		return directorService.getDirectors();
	}

	@PostMapping("/create")
	public DirectorDTO createDirector(@RequestBody @Valid DirectorDTO directorDTO) {
		return directorService.createDirector(directorDTO);
	}

	@PutMapping("/update")
	public DirectorDTO updateDirector(@RequestBody @Valid DirectorDTO directorDTO) throws FilmException {
		return directorService.updateDirector(directorDTO);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteDirector(@PathVariable Long id) {
		directorService.deleteDirector(id);
	}
}
