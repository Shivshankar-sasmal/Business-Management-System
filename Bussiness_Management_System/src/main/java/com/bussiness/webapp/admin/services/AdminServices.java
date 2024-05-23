package com.bussiness.webapp.admin.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bussiness.webapp.admin.DTO.AdminUsersDTO;
import com.bussiness.webapp.user.entity.UserEntity;

@Service
public class AdminServices {
	@Autowired
	AdminUsersDTO AdminUsersDTO_dto;
	
	public List<UserEntity> find_all_by_user_search (String search) {
		List<UserEntity> search_result;
		
		if ( search.equals("") ) {
			search_result = AdminUsersDTO_dto.findAll();
		}
		else {
			search_result = AdminUsersDTO_dto.findAllBySearch(search);
		}		
		
		Collections.sort(search_result, Comparator.comparing(UserEntity::getUser_id));
		return search_result;
	}
		
	
	
	public void admin_user_delete(Long user_id) {
		AdminUsersDTO_dto.deleteById(user_id);
	}
	
	
	public Optional<UserEntity> get_user(Long user_id) {
		return AdminUsersDTO_dto.findById(user_id);
	}
	
}
