package com.book.user.controller;

import com.book.user.pojo.User;
import com.book.user.service.UserService;
import com.book.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserService {

	@Autowired
	private UserServiceImpl userServiceImpl;
	@Override
	public User login(String userName, String password) {
		return this.userServiceImpl.userLogin(userName, password);
	}
}
