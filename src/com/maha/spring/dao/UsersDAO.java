package com.maha.spring.dao;

import java.util.List;

import com.maha.spring.entity.User;

public interface UsersDAO {

	public List<User> getUser();
	
	public void saveUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);
	
}
