package com.maha.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maha.spring.entity.RevenueEntity;

@Repository
public class RevenueDAOImpl implements RevenueDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<RevenueEntity> getRevenues() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<RevenueEntity> theQuery = 
				currentSession.createQuery("from RevenueEntity", RevenueEntity.class);

		// execute query and get result list
		List<RevenueEntity> revenue = theQuery.getResultList();
				
		// return the results
		return revenue;
	}

	@Override
	public void saveRevenue(RevenueEntity revenue) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the user ... finally LOL
		currentSession.saveOrUpdate(revenue);
	}

	@Override
	public RevenueEntity getRevenue(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		RevenueEntity revenue = currentSession.get(RevenueEntity.class, theId);
		
		return revenue;
	}

	@Override
	public void deleteRevenue(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from RevenueEntity where id=:revenueId");
		theQuery.setParameter("revenueId", theId);

		theQuery.executeUpdate();
	}
}

