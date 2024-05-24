package com.bussiness.webapp.validate.user;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import com.bussiness.webapp.error.ErrorFetch;
import com.bussiness.webapp.user.entity.UserEntity;
import com.bussiness.webapp.admin.DTO.AdminUsersDTO;

@Service
public class AdminUserUpdateSave {
	@Autowired
	AdminUsersDTO adminUsersDTO_dto;
	
	
	public boolean admin_user_update_save(UserEntity user_update, BindingResult result, Long user_id) {
		
		for (FieldError error : result.getFieldErrors()) {
			ErrorFetch.add(error.getDefaultMessage().toString());
		}
		
		if ( user_update.getTotal_amount() <= 0 ) {
			ErrorFetch.add("Total Amount Cannot Be 0 or Less than 0");
		}
		
		
		if( ErrorFetch.error_list_count() == 0 ) {			
			UserEntity user_update_new = adminUsersDTO_dto.findOneByUser_Id( user_id );
			user_update_new.setFirst_name( user_update.getFirst_name() );
			user_update_new.setLast_name( user_update.getLast_name() );
			user_update_new.setEmail( user_update.getEmail() );
			user_update_new.setSomething_about_you( user_update.getSomething_about_you() );
			user_update_new.setTotal_amount( user_update.getTotal_amount() );
			user_update_new.setTotal_profit( user_update.getTotal_profit() );
			user_update_new.setTotal_loss( user_update.getTotal_loss() );
			user_update_new.setCreated_by( user_update.getCreated_by() );
			user_update_new.setCreated_date( user_update.getCreated_date() );
			user_update_new.setUpdated_by( "system" );
			user_update_new.setUpdated_date( LocalDateTime.now() );
			user_update.setPassword( user_update.getPassword() );
			user_update.setIs_active( user_update.isIs_active() );
			user_update_new.setIs_superuser( user_update.isIs_superuser() );
			adminUsersDTO_dto.save( user_update_new );
			return true;
		}	
		
		return false;
	}

}
