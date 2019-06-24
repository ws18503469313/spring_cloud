package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{
	
}
