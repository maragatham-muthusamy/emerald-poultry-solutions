package com.maha.spring.service;

import java.util.List;

import com.maha.spring.entity.Production;

public interface ProductionService {
	public List<Production> getProductions();

	public void saveProduction(Production production);
	
	public Production getProduction(int theId);

	public void deleteProduction(int theId);
}