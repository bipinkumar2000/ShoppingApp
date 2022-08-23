package com.ShoppingAPI.Shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingAPI.Shopping.entity.UserDetails;

@Repository
public interface UserDao extends JpaRepository<UserDetails,Long>{

}
