package com.bussiness.webapp.user.DTO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bussiness.webapp.user.entity.UserEntity;



public interface UserDTO extends JpaRepository<UserEntity, Long>{
	
	// Exists By Username
	boolean existsByUsernameAllIgnoreCase(String username);
	
	
	// Exists By Email
	boolean existsByEmailAllIgnoreCase(String email);
	
	
	// Find By Username and Password
	UserEntity findByUsernameAllIgnoreCaseAndPassword(String username, String password);
	
	
	// Find By Username
	UserEntity findOneByUsername(String username);
}
