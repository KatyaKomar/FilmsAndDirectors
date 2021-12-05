package com.komar.films.repository;

import com.komar.films.entity.FilmEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<FilmEntity, Long> {
}
