package com.bussiness.webapp.admin.services;

import java.util.List;

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
		
		if ( Boolean.valueOf(search) ) {
			search_result = AdminUsersDTO_dto.findAllBySearch(search);
		}
		else {
			search_result = AdminUsersDTO_dto.findAll();
		}		

		return search_result;
	}
		
	
}
