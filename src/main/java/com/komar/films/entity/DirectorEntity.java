package com.komar.films.entity;

import javax.persistence.*;

@Entity
@Table(name = "stage_director")
public class DirectorEntity {
	@Id
	@GeneratedValue
	@Column(name = "director_id", nullable = false)
	private Long id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "surname", nullable = false, length = 100)
	private String surname;

	@Column(name = "number_of_films", nullable = false)
	private Integer numberOfFilms;

	public DirectorEntity() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getNumberOfFilms() {
		return numberOfFilms;
	}

	public void setNumberOfFilms(Integer numberOfFilms) {
		this.numberOfFilms = numberOfFilms;
	}
}
