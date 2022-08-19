package com.ShoppingAPI.Shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingAPI.Shopping.entity.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking,Long> {

}
