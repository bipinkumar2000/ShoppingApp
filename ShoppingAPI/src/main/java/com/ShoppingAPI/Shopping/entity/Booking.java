package com.ShoppingAPI.Shopping.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingId;
	private String movieTitle;
	private int noOfPersons;
	private long userId;

	public Booking() {
		super();
	}

	public Booking(long bookingId, String movieTitle, int noOfPersons, long userId) {
		super();
		this.bookingId = bookingId;
		this.movieTitle = movieTitle;
		this.noOfPersons = noOfPersons;
		this.userId = userId;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getNoOfPersons() {
		return noOfPersons;
	}

	public void setNoOfPersons(int noOfPersons) {
		this.noOfPersons = noOfPersons;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingId, movieTitle, noOfPersons, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return bookingId == other.bookingId && Objects.equals(movieTitle, other.movieTitle)
				&& noOfPersons == other.noOfPersons && userId == other.userId;
	}

}
