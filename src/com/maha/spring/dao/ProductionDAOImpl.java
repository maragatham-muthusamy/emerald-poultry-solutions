package com.maha.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maha.spring.entity.Productions;

@Repository
public class ProductionDAOImpl implements ProductionDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Productions> getProductions() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Productions> theQuery = 
				currentSession.createQuery("from Productions", Productions.class);

		// execute query and get result list
		List<Productions> production = theQuery.getResultList();
				
		// return the results
		return production;
	}

	@Override
	public void saveProduction(Productions production) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the user ... finally LOL
		currentSession.saveOrUpdate(production);
	}

	@Override
	public Productions getProduction(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Productions production = currentSession.get(Productions.class, theId);
		
		return production;
	}

	@Override
	public void deleteProduction(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Productions where id=:productionId");
		theQuery.setParameter("productionId", theId);

		theQuery.executeUpdate();
	}
}

