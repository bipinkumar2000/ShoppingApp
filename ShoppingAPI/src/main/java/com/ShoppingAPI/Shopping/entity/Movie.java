package com.ShoppingAPI.Shopping.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long movieId;
	private String title;
	private Date releaseDate;

	public Movie() {
		super();
	}

	public Movie(long movieId, String title, Date releaseDate) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.releaseDate = releaseDate;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieId, releaseDate, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return movieId == other.movieId && Objects.equals(releaseDate, other.releaseDate)
				&& Objects.equals(title, other.title);
	}

}
