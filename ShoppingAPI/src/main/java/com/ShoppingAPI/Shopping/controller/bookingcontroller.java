package com.ShoppingAPI.Shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingAPI.Shopping.entity.Booking;
import com.ShoppingAPI.Shopping.entity.UserDetails;
import com.ShoppingAPI.Shopping.service.BookingService;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/user/movie/booking")
@RestController
public class bookingcontroller {

	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Boolean> addBooking(@RequestBody Booking booking) {
		return bookingService.addBooking(booking);
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Booking>> getBookings(@RequestBody UserDetails user){
		return bookingService.getBookings(user);
	}
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Boolean> updateBooking(@RequestBody Booking booking){
		return bookingService.updateBooking(booking);
	}
	@RequestMapping(value="/{bookingId}",method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteBooking(@PathVariable long bookingId){
		return bookingService.deleteBooking(bookingId);
	}
}


