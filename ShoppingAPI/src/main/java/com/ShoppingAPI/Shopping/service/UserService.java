package com.ShoppingAPI.Shopping.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ShoppingAPI.Shopping.entity.UserDetails;

@Service
public interface UserService {

	public ResponseEntity<Boolean> addUser(UserDetails user);

	public ResponseEntity<List<UserDetails>> getUsers();

	public ResponseEntity<Boolean> updateUser(UserDetails user);

	public ResponseEntity<Boolean> deleteUser(long userId);

}
