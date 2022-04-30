package com.maha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maha.spring.dao.UsersDAO;
import com.maha.spring.entity.Users;

@Service
public class UsersServiceImpl implements UsersService {

	// need to inject user dao
	@Autowired
	private UsersDAO userDAO;
	
	@Override
	@Transactional
	public List<Users> getUsers() {
		return userDAO.getUser();
	}

	@Override
	@Transactional
	public void saveUser(Users theUser) {

		userDAO.saveUser(theUser);
	}

	@Override
	@Transactional
	public Users getUser(int theId) {
		
		return userDAO.getUser(theId);
	}

	@Override
	@Transactional
	public void deleteUser(int theId) {
		
		userDAO.deleteUser(theId);
	}
}