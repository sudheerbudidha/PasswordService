package com.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.user.dto.UserDTO;
import com.user.entity.QUser;
import com.user.entity.User;
import com.user.service.UserRepository;
import com.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository repository;
	
	@Autowired
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public UserDTO findByUser(UserDTO user) {
		QUser userQuery = new QUser("user");
		Predicate  predicate = userQuery.username.eq(user.getUsername()).and(userQuery.password.eq(user.getPassword()));
		Iterable<User> users = repository.findAll(predicate);
		UserDTO dto = users != null ? convertToDTO(users.iterator().next()) : null;
		return dto;
	}
	
	@Override
	public UserDTO findByUser(User user) {
		QUser userQuery = new QUser("user");
		Predicate  predicate = userQuery.username.eq(user.getUsername()).and(userQuery.password.eq(user.getPassword()));
		Iterable<User> users = repository.findAll(predicate);
		UserDTO dto = users != null ? convertToDTO(users.iterator().next()) : null;
		return dto;
	}

	@Override
	public UserDTO registerUser(UserDTO user) {
		User entity = convertToEntity(user);
		entity = repository.save( entity);
		return convertToDTO(entity);
	}
	
	public UserDTO convertToDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setPassword(user.getPassword());
		dto.setUsername(user.getUsername());
		return dto;
	}
	
	public User convertToEntity(UserDTO user) {
		User entity = new User();
		entity.setPassword(user.getPassword());
		entity.setUsername(user.getUsername());
		entity.setFirstName(user.getFirstName());
		entity.setLastName(user.getLastName());
		return entity;
	}

}
