package com.maha.spring.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maha.spring.entity.Production;


public interface ProductionRepository extends JpaRepository<Production, Long> {

}
