package com.bussiness.webapp.current_user;

import com.bussiness.webapp.user.entity.UserEntity;

public class CurrentUser {
	public static UserEntity user = null;
			
	public static void set_user(UserEntity logged_in_userr) {
		user = logged_in_userr;
	}
}
