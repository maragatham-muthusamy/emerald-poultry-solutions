package com.maha.spring.service;

import java.util.List;

import com.maha.spring.entity.User;

public interface UsersService {

	public List<User> getUsers();

	public void saveUser(User theUser);
	
	public User getUser(int theId);

	public void deleteUser(int theId);
	
}