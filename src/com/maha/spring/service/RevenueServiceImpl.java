package com.maha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maha.spring.dao.RevenueDAO;
import com.maha.spring.entity.RevenueEntity;

@Service
public class RevenueServiceImpl implements RevenueService {

	// need to inject user dao
	@Autowired
	private RevenueDAO revenueDAO;
	
	@Override
	@Transactional
	public List<RevenueEntity> getRevenues() {
		return revenueDAO.getRevenues();
	}

	@Override
	@Transactional
	public void saveRevenue(RevenueEntity revenue) {

		revenueDAO.saveRevenue(revenue);
	}

	@Override
	@Transactional
	public RevenueEntity getRevenue(int theId) {
		
		return revenueDAO.getRevenue(theId);
	}

	@Override
	@Transactional
	public void deleteRevenue(int theId) {
		
		revenueDAO.deleteRevenue(theId);
	}
}