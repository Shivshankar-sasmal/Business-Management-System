package com.bussiness.webapp.user.validate;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.bussiness.webapp.current_user.CurrentUser;
import com.bussiness.webapp.error.ErrorFetch;
import com.bussiness.webapp.user.DTO.UserDTO;
import com.bussiness.webapp.user.entity.UserEntity;

@Service
public class UserProfileSaveValidate {
	
	@Autowired
	UserDTO UserDTO_dto;
	
	
	public boolean user_profile_save(UserEntity user_update, BindingResult result) {
				
		for (FieldError error : result.getFieldErrors()) {
			ErrorFetch.add(error.getDefaultMessage().toString());
		}
		
		
		if ( ! user_update.getUsername().equals(CurrentUser.user.getUsername()) ) {
				ErrorFetch.add("Username Already Exists");
		}
		
	
		if ( ! user_update.getEmail().equals(CurrentUser.user.getEmail()) ) {
				ErrorFetch.add("Email Already Exists");
		}

		
		if ( user_update.getTotal_amount() <= 0 ) {
			ErrorFetch.add("Total Amount Cannot Be 0 or Less than 0");
		}
		
		
		if( ErrorFetch.error_list_count() == 0 ) {
			UserEntity user_update_new = UserDTO_dto.findOneByUsername(user_update.getUsername());
			user_update_new.setUsername( user_update.getUsername() );
			user_update_new.setFirst_name( user_update.getFirst_name() );
			user_update_new.setLast_name( user_update.getLast_name() );
			user_update_new.setEmail( user_update.getEmail() );
			user_update_new.setSomething_about_you( user_update.getSomething_about_you() );
			user_update_new.setTotal_amount( user_update.getTotal_amount() );
			user_update_new.setTotal_profit( user_update.getTotal_profit() );
			user_update_new.setTotal_loss( user_update.getTotal_loss() );
			user_update_new.setUpdated_by( user_update.getUser_id() + "_" + user_update.getUsername() );
			user_update_new.setUpdated_date( LocalDateTime.now() );
			UserDTO_dto.save(user_update_new);
			CurrentUser.user = user_update_new;
			return true;
		}	
				
		return false;
	}

}
