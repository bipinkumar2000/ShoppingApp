package com.ShoppingAPI.Shopping.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ShoppingAPI.Shopping.entity.Booking;
import com.ShoppingAPI.Shopping.entity.UserDetails;

@Service
public interface BookingService {
	
	public ResponseEntity<Boolean> addBooking(Booking booking);
	public ResponseEntity<List<Booking>> getBookings(UserDetails user);
	public ResponseEntity<Boolean> deleteBooking(long bookingId);
	public ResponseEntity<Boolean> updateBooking(Booking booking);

}
