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
public class ShowCycle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long showCycleId;
	private Date showCycleTime;
	private long movieId;

	public ShowCycle() {
		super();
	}

	public ShowCycle(long showCycleId, Date showCycleTime, long movieId) {
		super();
		this.showCycleId = showCycleId;
		this.showCycleTime = showCycleTime;
		this.movieId = movieId;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public long getShowCycleId() {
		return showCycleId;
	}

	public void setShowCycleId(long showCycleId) {
		this.showCycleId = showCycleId;
	}

	public Date getShowCycleTime() {
		return showCycleTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieId, showCycleId, showCycleTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShowCycle other = (ShowCycle) obj;
		return movieId == other.movieId && showCycleId == other.showCycleId
				&& Objects.equals(showCycleTime, other.showCycleTime);
	}

	public void setShowCycleTime(Date showCycleTime) {
		this.showCycleTime = showCycleTime;
	}

}
