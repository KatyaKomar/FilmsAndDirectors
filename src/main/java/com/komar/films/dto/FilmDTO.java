package com.komar.films.dto;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class FilmDTO {
	@NotNull
	private Long id;

	@NotNull
	private String title;

	@NotNull
	private String description;

	@NotNull
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private LocalDate releaseDate;

	@NotNull
	@Min(0)
	@Max(10)
	private BigDecimal rating;

	@NotNull
	private Integer numberOfViews;

	@NotNull
	private List<DirectorDTO> directors;

	public FilmDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<DirectorDTO> getDirectors() {
		return directors;
	}

	public void setDirectors(List<DirectorDTO> directors) {
		this.directors = directors;
	}

	@Override
	public String toString() {
		return "FilmDTO{" +
				"id=" + id +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", releaseDate=" + releaseDate +
				", rating=" + rating +
				", numberOfViews=" + numberOfViews +
				", directors=" + directors.toString() +
				'}';
	}
}
