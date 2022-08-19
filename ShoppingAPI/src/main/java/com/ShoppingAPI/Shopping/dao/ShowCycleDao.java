package com.ShoppingAPI.Shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingAPI.Shopping.entity.ShowCycle;

@Repository
public interface ShowCycleDao extends JpaRepository<ShowCycle,Long> {

}
