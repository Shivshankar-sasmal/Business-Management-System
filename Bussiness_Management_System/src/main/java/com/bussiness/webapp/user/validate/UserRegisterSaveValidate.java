package com.bussiness.webapp.user.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.bussiness.webapp.error.ErrorFetch;
import com.bussiness.webapp.user.entity.UserEntity;
import com.bussiness.webapp.validate.encryption_decryption.Encrypt_Decrypt;
import com.bussiness.webapp.user.DTO.UserDTO;

@Service
public class UserRegisterSaveValidate {
	
	@Autowired
	UserDTO UserDTO_dto;
	
	public boolean user_register_save_validate(UserEntity user_register, BindingResult result) {
		
		for (FieldError error : result.getFieldErrors()) {
			ErrorFetch.add(error.getDefaultMessage().toString());
		}
		
		
		if ( UserDTO_dto.existsByUsernameAllIgnoreCase(user_register.getUsername()) ) {
			ErrorFetch.add("Username Already Exists");
		}
		
		if ( UserDTO_dto.existsByEmailAllIgnoreCase(user_register.getEmail()) ) {
			ErrorFetch.add("Email Already Exists");
		}
		
		if ( user_register.getTotal_amount() <= 0 ) {
			ErrorFetch.add("Total Amount Cannot Be 0 or Less than 0");
		}
		
		
		if ( ErrorFetch.error_list_count() == 0 ) {
			user_register.setPassword(Encrypt_Decrypt.encrypt(user_register.getPassword()));
			UserDTO_dto.save(user_register);			
			return true;
		}
		
		
		return false;
	}
}
