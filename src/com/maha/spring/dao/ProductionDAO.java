package com.maha.spring.dao;

import java.util.List;

import com.maha.spring.entity.Productions;

public interface ProductionDAO {

	public List<Productions> getProductions();
	
	public void saveProduction(Productions production);

	public Productions getProduction(int theId);

	public void deleteProduction(int theId);

}
