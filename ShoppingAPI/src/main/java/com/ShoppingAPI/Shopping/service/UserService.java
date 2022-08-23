package com.ShoppingAPI.Shopping.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ShoppingAPI.Shopping.entity.User;

@Service
public interface UserService {

	public ResponseEntity<Boolean> addUser(User user);

	public ResponseEntity<List<User>> getUsers();

	public ResponseEntity<Boolean> updateUser(User user);

	public ResponseEntity<Boolean> deleteUser(long userId);

}
