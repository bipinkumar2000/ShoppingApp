package com.ShoppingAPI.Shopping.entity;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long movieId;
	private String title;
	private Date releaseDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_movieId", referencedColumnName="movieId")
	private List<ShowCycle> showCycles;

	public Movie() {
		super();
	}

	public Movie(long movieId, String title, Date releaseDate, List<ShowCycle> showCycles) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.releaseDate = releaseDate;
		this.showCycles = showCycles;
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

	public List<ShowCycle> getShowCycles() {
		return showCycles;
	}

	public void setShowCycles(List<ShowCycle> showCycles) {
		this.showCycles = showCycles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieId, releaseDate, showCycles, title);
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
				&& Objects.equals(showCycles, other.showCycles) && Objects.equals(title, other.title);
	}
	
	

	
}
