package com.maha.spring.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maha.spring.entity.Production;


public interface ProductionRepository extends JpaRepository<Production, Long> {

	@Query("SELECT p FROM Production p WHERE p.userId = ?1")
	public List<Production> findAllById(Long id);
}
