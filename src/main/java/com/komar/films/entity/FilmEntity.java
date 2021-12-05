package com.komar.films.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "favorite_films")
public class FilmEntity {
	@Id
	@GeneratedValue
	@Column(name = "film_id", nullable = false)
	private Long id;

	@Column(name = "movie_title", nullable = false, length = 123)
	private String title;

	@Column(name = "movie_description", length = 1000)
	private String description;

	@Column(name = "release_date", nullable = false)
	private LocalDate releaseDate;

	@Column(name = "rating", nullable = false, precision = 3, scale = 2)
	private BigDecimal rating;

	@Column(name = "number_of_views", nullable = false)
	private Integer numberOfViews;

	@ManyToMany
	@Column(name = "directors", nullable = false)
	private List<DirectorEntity> directors;

	public FilmEntity() {
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public Integer getNumberOfViews() {
		return numberOfViews;
	}

	public void setNumberOfViews(Integer numberOfViews) {
		this.numberOfViews = numberOfViews;
	}

	public List<DirectorEntity> getDirectors() {
		return directors;
	}

	public void setDirectors(List<DirectorEntity> directors) {
		this.directors = directors;
	}
}
