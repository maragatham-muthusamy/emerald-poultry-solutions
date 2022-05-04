package com.maha.spring.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maha.spring.entity.Users;

public class UserRepository extends JpaRepository<Users, Long> {

}
