package com.komar.films.service;

import com.komar.films.dto.DirectorDTO;
import com.komar.films.entity.DirectorEntity;
import com.komar.films.exception.ExceptionType;
import com.komar.films.exception.FilmException;
import com.komar.films.mapper.DirectorMapper;
import com.komar.films.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectorService {
	private final DirectorRepository directorRepository;

	private final DirectorMapper directorMapper;

	@Autowired
	public DirectorService(DirectorRepository directorRepository, DirectorMapper directorMapper) {
		this.directorRepository = directorRepository;

		this.directorMapper = directorMapper;
	}

	@Transactional(readOnly = true)
	public DirectorDTO getDirector(Long directorId) throws FilmException {
		DirectorEntity directorEntity = findById(directorId);
		return directorMapper.entityToDTO(directorEntity);
	}

	@Transactional(readOnly = true)
	public List<DirectorDTO> getDirectors() {
		List<DirectorDTO> result = new ArrayList<>();
		directorRepository.findAll().forEach(director -> result.add(directorMapper.entityToDTO(director)));
		return result;
	}

	@Transactional
	public DirectorDTO createDirector(DirectorDTO directorDTO) {
		DirectorEntity directorEntity = directorMapper.dtoToEntity(directorDTO);
		directorEntity = directorRepository.save(directorEntity);
		return directorMapper.entityToDTO(directorEntity);
	}

	@Transactional
	public DirectorDTO updateDirector(DirectorDTO directorDTO) throws FilmException {
		DirectorEntity directorEntity = findById(directorDTO.getId());
		directorMapper.updateEntityWithDTO(directorEntity, directorDTO);
		directorEntity = directorRepository.save(directorEntity);
		return directorMapper.entityToDTO(directorEntity);
	}

	@Transactional
	public void deleteDirector(Long id) {
		directorRepository.deleteById(id);
	}

	public boolean isDirectorExist(String name, String surname) {
		return directorRepository.findByNameAndSurname(name, surname).isPresent();
	}

	public DirectorEntity findByNameAndSurname(String name, String surname) throws FilmException {
		return directorRepository.findByNameAndSurname(name, surname)
		                         .orElseThrow(() -> new FilmException(ExceptionType.DIRECTOR_NOT_FOUND));
	}

	private DirectorEntity findById(Long id) throws FilmException {
		return directorRepository.findById(id)
		                         .orElseThrow(() -> new FilmException(ExceptionType.DIRECTOR_NOT_FOUND));
	}
}
