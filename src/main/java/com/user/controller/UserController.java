package com.user.controller;

import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.UserDTO;
import com.user.service.UserService;
import com.user.service.impl.UserServiceImpl;

@RequestMapping("/user")
@RestController
public class UserController {
	
	private final UserService service;
	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	public UserController(UserServiceImpl service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO register(@RequestBody UserDTO user) {
		return service.registerUser(user);
	}
	
	@RequestMapping(method = RequestMethod.POST, path="/login")
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO login(@RequestBody UserDTO user) {
		UserDTO loggedUser = null;
		try {
		 loggedUser = service.findByUser(user);
		}catch(NoSuchElementException nee) {
			logger.debug("Login failed with user:"+user.getUsername()+" and password:"+user.getPassword());
		}
		return loggedUser;
	}
}
