package com.ShoppingAPI.Shopping.entity;


import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingId;
	
	@NotBlank(message="Movie title must not be blank")
	@Column(name="movieTitle")
	private String movieTitle;
	
	@NotBlank(message="No of tickets needed must not be blank")
	@Column(name="noOfPersons")
	private int noOfPersons;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_showcycleId")
	private ShowCycle showCycle;
	
	

	public Booking() {
		super();
	}

	public Booking(long bookingId, @NotBlank(message = "Movie title must not be blank") String movieTitle,
			@NotBlank(message = "No of tickets needed must not be blank") int noOfPersons, ShowCycle showCycle,
			UserDetails user) {
		super();
		this.bookingId = bookingId;
		this.movieTitle = movieTitle;
		this.noOfPersons = noOfPersons;
		this.showCycle = showCycle;
		
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

	public ShowCycle getShowCycle() {
		return showCycle;
	}

	public void setShowCycle(ShowCycle showCycle) {
		this.showCycle = showCycle;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(bookingId, movieTitle, noOfPersons, showCycle);
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
				&& noOfPersons == other.noOfPersons && Objects.equals(showCycle, other.showCycle);
	}

	

	
}
