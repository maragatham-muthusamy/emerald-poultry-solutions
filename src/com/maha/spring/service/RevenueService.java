package com.maha.spring.service;

import java.util.List;

import com.maha.spring.entity.RevenueEntity;

public interface RevenueService {
	public List<RevenueEntity> getRevenues();

	public void saveRevenue(RevenueEntity revenue);
	
	public RevenueEntity getRevenue(int theId);

	public void deleteRevenue(int theId);
}