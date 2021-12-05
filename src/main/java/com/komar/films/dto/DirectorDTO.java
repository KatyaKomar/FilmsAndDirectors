package com.komar.films.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.Max;

public class DirectorDTO {
	@NotNull
	private Long id;

	@NotNull
	@Max(100)
	private String name;

	@NotNull
	@Max(100)
	private String surname;

	@NotNull
	private Integer numberOfFilms;

	public DirectorDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
