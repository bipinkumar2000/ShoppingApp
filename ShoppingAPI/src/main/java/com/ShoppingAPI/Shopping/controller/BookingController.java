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
import com.ShoppingAPI.Shopping.service.BookingService;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/movie/booking")
@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Boolean> addBooking(@RequestBody Booking booking) {
		return bookingService.addBooking(booking);
	}
	@RequestMapping(value="/{userId}",method=RequestMethod.GET)
	public ResponseEntity<List<Booking>> getBookings(@PathVariable long userId){
		return bookingService.getBookings(userId);
	}
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Boolean> updateBooking(@RequestBody Booking booking){
		return bookingService.updateBooking(booking);
	}
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteBooking(@PathVariable long id){
		return bookingService.deleteBooking(id);
	}
}
