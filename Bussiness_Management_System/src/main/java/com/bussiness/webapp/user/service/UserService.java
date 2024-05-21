package com.bussiness.webapp.user.service;


import com.bussiness.webapp.user.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bussiness.webapp.user.DTO.UserDTO;

@Service
public class UserService {
	@Autowired
	UserDTO UserDTO_dto;
	
	
	public UserEntity create_new_user() {
		return new UserEntity();
	}
	
	public void save_user(UserEntity user) {
		UserDTO_dto.save(user);
	}
	
}
