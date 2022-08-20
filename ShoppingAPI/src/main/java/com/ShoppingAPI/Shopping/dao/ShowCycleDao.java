package com.ShoppingAPI.Shopping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ShoppingAPI.Shopping.entity.ShowCycle;

@Repository
public interface ShowCycleDao extends JpaRepository<ShowCycle,Long> {
	
	@Query("SELECT s FROM ShowCycle s WHERE s.movieId = :movieId")
	public List<ShowCycle> findAll(long movieId);
}
