package com.ShoppingAPI.Shopping.service.BookingServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ShoppingAPI.Shopping.dao.BookingDao;
import com.ShoppingAPI.Shopping.dao.UserDao;
import com.ShoppingAPI.Shopping.entity.Booking;
import com.ShoppingAPI.Shopping.entity.UserDetails;
import com.ShoppingAPI.Shopping.service.BookingService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingDao bookingDao;
	

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly=false)
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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly=false)
	@Cacheable(value="moviesbooking",key="#userId")
	public ResponseEntity<List<Booking>> getBookings(UserDetails user) {
		if(user!=null) {
			List<Booking> bookings=user.getBookings();
			if(bookings!=null) {
				return new ResponseEntity<List<Booking>>(bookings,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<Booking>>(HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly=false)
	@CacheEvict(value="moviesbooking",key="#bookingId")
	public ResponseEntity<Boolean> deleteBooking(long bookingId) {
		if(bookingId>0) {
			var booking =  bookingDao.findById(bookingId);
			if(booking!=null) {
				try {
					bookingDao.deleteById(bookingId);
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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
	@CachePut(value="moviesbooking",key="#booking.bookingId")
	public ResponseEntity<Boolean> updateBooking(Booking booking) {
		if(booking!=null) {
			var id = booking.getBookingId();
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
