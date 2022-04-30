package com.maha.spring.dao;

import java.util.List;

import com.maha.spring.entity.Users;

public interface UsersDAO {

	public List<Users> getUser();
	
	public void saveUser(Users theUser);

	public Users getUser(int theId);

	public void deleteUser(int theId);
	
}
