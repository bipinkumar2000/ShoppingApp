package com.ShoppingAPI.Shopping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ShoppingAPI.Shopping.entity.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking,Long> {
	
	@Query("SELECT b FROM Booking b WHERE b.userId = :userId")
	public List<Booking> findAll(long userId);

}
