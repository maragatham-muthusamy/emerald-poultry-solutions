package com.maha.spring.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maha.spring.entity.ContactUs;


public interface ContactusRepository extends JpaRepository<ContactUs, Long> {

}
