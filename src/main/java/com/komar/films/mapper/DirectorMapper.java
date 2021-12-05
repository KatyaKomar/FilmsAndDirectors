package com.komar.films.mapper;

import com.komar.films.dto.DirectorDTO;
import com.komar.films.entity.DirectorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectorMapper {
	@Autowired
	public DirectorMapper() {

	}

	public DirectorEntity dtoToEntity(DirectorDTO directorDTO) {
		DirectorEntity directorEntity = new DirectorEntity();
		updateEntityWithDTO(directorEntity, directorDTO);
		return directorEntity;
	}

	public void updateEntityWithDTO(DirectorEntity directorEntity, DirectorDTO directorDTO) {
		directorEntity.setName(directorDTO.getName());
		directorEntity.setSurname(directorDTO.getSurname());
		directorEntity.setNumberOfFilms(directorDTO.getNumberOfFilms());
	}

	public DirectorDTO entityToDTO(DirectorEntity directorEntity) {
		DirectorDTO directorDTO = new DirectorDTO();
		directorDTO.setId(directorEntity.getId());
		directorDTO.setName(directorEntity.getName());
		directorDTO.setSurname(directorEntity.getSurname());
		directorDTO.setNumberOfFilms(directorEntity.getNumberOfFilms());

		return directorDTO;
	}
}
