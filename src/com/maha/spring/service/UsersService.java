package com.maha.spring.service;

import java.util.List;

import com.maha.spring.entity.Users;

public interface UsersService {

	public List<Users> getUsers();

	public void saveUser(Users theUser);
	
	public Users getUser(int theId);

	public void deleteUser(int theId);
	
}