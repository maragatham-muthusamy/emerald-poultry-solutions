package com.maha.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maha.spring.entity.Users;

@Repository
public class UsersDAOImpl implements UsersDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Users> getUser() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Users> theQuery = 
				currentSession.createQuery("from Users order by lastName",
											Users.class);
		
		// execute query and get result list
		List<Users> users = theQuery.getResultList();
				
		// return the results		
		return users;
	}

	@Override
	public void saveUser(Users theUser) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the user ... finally LOL
		currentSession.saveOrUpdate(theUser);
		
	}

	@Override
	public Users getUser(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Users theUser = currentSession.get(Users.class, theId);
		
		return theUser;
	}

	@Override
	public void deleteUser(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from User where id=:userId");
		theQuery.setParameter("userId", theId);
		
		theQuery.executeUpdate();
	}
}

