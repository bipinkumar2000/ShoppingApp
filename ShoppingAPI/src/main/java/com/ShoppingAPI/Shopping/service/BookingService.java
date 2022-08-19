package com.ShoppingAPI.Shopping.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ShoppingAPI.Shopping.entity.Booking;

@Service
public interface BookingService {
	
	public ResponseEntity<Boolean> addBooking(Booking booking);
	public ResponseEntity<List<Booking>> getBookings(long userId);
	public ResponseEntity<Boolean> deleteBooking(long id);
	public ResponseEntity<Boolean> updateBooking(Booking booking);
	

}
