package com.ShoppingAPI.Shopping.service.UserServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ShoppingAPI.Shopping.dao.UserDao;
import com.ShoppingAPI.Shopping.entity.User;
import com.ShoppingAPI.Shopping.service.UserService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly=false)
	public ResponseEntity<Boolean> addUser(User user) {
		if(user!=null) {
			userDao.save(user);
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false,HttpStatus.NO_CONTENT);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public ResponseEntity<List<User>> getUsers() {
		List<User> users =  userDao.findAll();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);	
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly=false)
	public ResponseEntity<Boolean> updateUser(User user) {
		var id=user.getUserId();
		var _user=userDao.findById(id);
		if(_user!=null) {
			userDao.save(user);
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
	}
	

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly=false)
	public ResponseEntity<Boolean> deleteUser(long userId) {
		var user=userDao.findById(userId);
		if(user!=null) {
			userDao.deleteById(userId);
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
	}

	
}
