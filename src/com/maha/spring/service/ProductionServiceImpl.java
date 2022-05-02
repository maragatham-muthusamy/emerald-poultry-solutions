package com.maha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maha.spring.dao.ProductionDAO;
import com.maha.spring.entity.Productions;

@Service
public class ProductionServiceImpl implements ProductionService {

	// need to inject user dao
	@Autowired
	private ProductionDAO productionDAO;
	
	@Override
	@Transactional
	public List<Productions> getProductions() {
		return productionDAO.getProductions();
	}

	@Override
	@Transactional
	public void saveProduction(Productions production) {

		productionDAO.saveProduction(production);
	}

	@Override
	@Transactional
	public Productions getProduction(int theId) {
		
		return productionDAO.getProduction(theId);
	}

	@Override
	@Transactional
	public void deleteProduction(int theId) {
		
		productionDAO.deleteProduction(theId);
	}
}