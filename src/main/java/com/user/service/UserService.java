package com.user.service;

import com.user.dto.UserDTO;
import com.user.entity.User;

public interface UserService {
	
	UserDTO findByUser(UserDTO user);
	UserDTO registerUser(UserDTO user);
	
	//Test
	UserDTO findByUser(User user);
}
