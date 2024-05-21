package com.bussiness.webapp.user.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bussiness.webapp.current_user.CurrentUser;
import com.bussiness.webapp.user.DTO.UserDTO;
import com.bussiness.webapp.user.entity.UserEntity;
import com.bussiness.webapp.validate.encryption_decryption.Encrypt_Decrypt;

@Service
public class UserLoginValidate {
	
	@Autowired
	UserDTO UserDTO_dto;
	
	public boolean user_login_validate(String username, String password) {
		UserEntity user = UserDTO_dto.findByUsernameAllIgnoreCaseAndPassword(username.trim(), Encrypt_Decrypt.encrypt(password).trim()); 
		
		if ( user == null ) {			
			return false;
		}
		
		CurrentUser.set_user(user);
		return true;
	}
}
