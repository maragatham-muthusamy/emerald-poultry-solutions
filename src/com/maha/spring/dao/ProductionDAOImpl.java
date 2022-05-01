package com.maha.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maha.spring.entity.Production;

@Repository
public class ProductionDAOImpl implements ProductionDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Production> getProductions() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Production> theQuery = 
				currentSession.createQuery("from Production", Production.class);

		// execute query and get result list
		List<Production> production = theQuery.getResultList();
				
		// return the results
		return production;
	}

	@Override
	public void saveProduction(Production production) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the user ... finally LOL
		currentSession.saveOrUpdate(production);
	}

	@Override
	public Production getProduction(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Production production = currentSession.get(Production.class, theId);
		
		return production;
	}

	@Override
	public void deleteProduction(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Production where id=:productionId");
		theQuery.setParameter("productionId", theId);

		theQuery.executeUpdate();
	}
}

