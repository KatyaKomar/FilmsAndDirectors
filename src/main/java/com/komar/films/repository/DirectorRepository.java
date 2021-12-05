package com.komar.films.repository;

import com.komar.films.entity.DirectorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectorRepository extends CrudRepository<DirectorEntity, Long> {
	public Optional<DirectorEntity> findByNameAndSurname(String name, String surname);
}
