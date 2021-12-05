package com.komar.films.service;

import com.komar.films.dto.FilmDTO;
import com.komar.films.entity.FilmEntity;
import com.komar.films.exception.ExceptionType;
import com.komar.films.exception.FilmException;
import com.komar.films.mapper.FilmMapper;
import com.komar.films.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {
	private final FilmRepository filmRepository;

	private final FilmMapper filmMapper;

	@Autowired
	public FilmService(FilmRepository filmRepository, FilmMapper filmMapper) {
		this.filmRepository = filmRepository;

		this.filmMapper = filmMapper;
	}

	@Transactional(readOnly = true)
	public FilmDTO getFilm(Long filmId) throws FilmException {
		FilmEntity filmEntity = findById(filmId);
		return filmMapper.entityToDTO(filmEntity);
	}

	@Transactional(readOnly = true)
	public List<FilmDTO> getFilms() {
		List<FilmDTO> result = new ArrayList<>();
		filmRepository.findAll().forEach(film -> result.add(filmMapper.entityToDTO(film)));
		return result;
	}

	@Transactional
	public FilmDTO createFilm(FilmDTO filmDTO) throws FilmException {
		FilmEntity filmEntity = filmMapper.dtoToEntity(filmDTO);
		filmEntity = filmRepository.save(filmEntity);
		return filmMapper.entityToDTO(filmEntity);
	}

	@Transactional
	public FilmDTO updateFilm(FilmDTO filmDTO) throws FilmException {
		FilmEntity filmEntity = findById(filmDTO.getId());
		filmMapper.updateEntityWithDTO(filmEntity, filmDTO);
		filmEntity = filmRepository.save(filmEntity);
		return filmMapper.entityToDTO(filmEntity);
	}

	@Transactional
	public void deleteFilm(Long id) {
		filmRepository.deleteById(id);
	}

	private FilmEntity findById(Long id) throws FilmException {
		return filmRepository.findById(id)
		                     .orElseThrow(() -> new FilmException(ExceptionType.FILM_NOT_FOUND));
	}
}
