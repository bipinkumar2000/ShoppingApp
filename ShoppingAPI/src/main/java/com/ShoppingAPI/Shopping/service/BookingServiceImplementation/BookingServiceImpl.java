package com.ShoppingAPI.Shopping.service.BookingServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ShoppingAPI.Shopping.dao.BookingDao;
import com.ShoppingAPI.Shopping.entity.Booking;
import com.ShoppingAPI.Shopping.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingDao bookingDao;

	@Override
	public ResponseEntity<Boolean> addBooking(Booking booking) {
		if(booking!=null) {
			try {
				bookingDao.save(booking);
				return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		else {
			return new ResponseEntity<Boolean>(false,HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<List<Booking>> getBookings(long userId) {
		if(userId>0) {
			var booking = bookingDao.findAll(userId);
			if(booking!=null) {
				return new ResponseEntity<List<Booking>>(booking,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<Boolean> deleteBooking(long id) {
		if(id>0) {
			var booking =  bookingDao.findById(id);
			if(booking!=null) {
				try {
					bookingDao.deleteById(id);;
					return new ResponseEntity<Boolean>(true,HttpStatus.OK);
				}
				catch(Exception e) {
					return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			else {
				return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
			}
		}
		else {
			return new ResponseEntity<Boolean>(false,HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<Boolean> updateBooking(Booking booking) {
		if(booking!=null) {
			var id = booking.getUserId();
			var _booking = bookingDao.findById(id);
			if(_booking!=null) {
				try {
					bookingDao.save(booking);
					return new ResponseEntity<Boolean>(true,HttpStatus.OK);
				}
				catch(Exception e) {
					return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			else {
				return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
			}
			}
		else {
			return new ResponseEntity<Boolean>(false,HttpStatus.NO_CONTENT);
		}
		
	}

}
