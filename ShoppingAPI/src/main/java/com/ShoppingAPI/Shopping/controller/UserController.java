package com.ShoppingAPI.Shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingAPI.Shopping.entity.UserDetails;
import com.ShoppingAPI.Shopping.service.UserService;
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/user")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Boolean> addUser(@RequestBody UserDetails user){
		return userService.addUser(user);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> getUsers(){
		return userService.getUsers();
	}

	@RequestMapping(value="/{userId}",method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteUser(@PathVariable long userId){
		return userService.deleteUser(userId);
	}

	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Boolean> updateUser(@RequestBody UserDetails user){
		return userService.updateUser(user);
	}
}
