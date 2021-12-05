package com.komar.films.mapper;

import com.komar.films.dto.DirectorDTO;
import com.komar.films.dto.FilmDTO;
import com.komar.films.entity.DirectorEntity;
import com.komar.films.entity.FilmEntity;
import com.komar.films.exception.FilmException;
import com.komar.films.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilmMapper {
	private final DirectorService directorService;

	private final DirectorMapper directorMapper;

	@Autowired
	public FilmMapper(DirectorService directorService, DirectorMapper directorMapper) {
		this.directorService = directorService;

		this.directorMapper = directorMapper;
	}

	public FilmEntity dtoToEntity(FilmDTO filmDTO) throws FilmException {
		FilmEntity filmEntity = new FilmEntity();
		updateEntityWithDTO(filmEntity, filmDTO);
		List<DirectorDTO> directorDTOS = filmDTO.getDirectors();
		List<DirectorEntity> directors = new ArrayList<>();
		for (DirectorDTO directorDTO : directorDTOS) {
			if (!directorService.isDirectorExist(directorDTO.getName(), directorDTO.getSurname())) {
				directorDTO = directorService.createDirector(directorDTO);
			}
			DirectorEntity directorEntity = directorService.findByNameAndSurname(directorDTO.getName(), directorDTO.getSurname());
			directors.add(directorEntity);
		}
		filmEntity.setDirectors(directors);
		return filmEntity;
	}

	public void updateEntityWithDTO(FilmEntity filmEntity, FilmDTO filmDTO) {
		filmEntity.setTitle(filmDTO.getTitle());
		filmEntity.setDescription(filmDTO.getDescription());
		filmEntity.setReleaseDate(filmDTO.getReleaseDate());
		filmEntity.setRating(filmDTO.getRating());
		filmEntity.setNumberOfViews(filmDTO.getNumberOfViews());
	}

	public FilmDTO entityToDTO(FilmEntity filmEntity) {
		FilmDTO filmDTO = new FilmDTO();
		filmDTO.setId(filmEntity.getId());
		filmDTO.setTitle(filmEntity.getTitle());
		filmDTO.setDescription(filmEntity.getDescription());
		filmDTO.setReleaseDate(filmEntity.getReleaseDate());
		filmDTO.setRating(filmEntity.getRating());
		filmDTO.setNumberOfViews(filmEntity.getNumberOfViews());
		return filmDTO;
	}
}
