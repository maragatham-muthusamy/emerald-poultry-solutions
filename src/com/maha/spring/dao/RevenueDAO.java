package com.maha.spring.dao;

import java.util.List;

import com.maha.spring.entity.RevenueEntity;

public interface RevenueDAO {

	public List<RevenueEntity> getRevenue();
	
	public void saveRevenue(RevenueEntity revenue);

	public RevenueEntity getRevenue(int theId);

	public void deleteRevenue(int theId);

}
