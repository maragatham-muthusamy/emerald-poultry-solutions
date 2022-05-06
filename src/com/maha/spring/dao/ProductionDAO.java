package com.maha.spring.dao;

import java.util.List;

import com.maha.spring.entity.Production;

public interface ProductionDAO {

	public List<Production> getProductions();
	
	public void saveProduction(Production production);

	public Production getProduction(int theId);

	public void deleteProduction(int theId);

}
