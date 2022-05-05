package com.maha.spring.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maha.spring.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	@Query("SELECT u FROM User u WHERE u.email = ?1")
	Users findByEmail(String email);
}
