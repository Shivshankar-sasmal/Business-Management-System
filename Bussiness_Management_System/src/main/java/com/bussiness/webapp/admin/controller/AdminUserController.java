package com.bussiness.webapp.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bussiness.webapp.current_user.CurrentUser;
import com.bussiness.webapp.error.ErrorFetch;
import com.bussiness.webapp.user.entity.UserEntity;

import jakarta.validation.Valid;

import com.bussiness.webapp.admin.services.AdminServices;
import com.bussiness.webapp.user.validate.AdminUserUpdateSave;


@Controller
@RequestMapping("/")
public class AdminUserController {
	@Autowired
	AdminServices AdminServices_services;
	
	@Autowired
	AdminUserUpdateSave AdminUserUpdateSave_validate;
	
	
	@GetMapping("/admin/users")
	public String get_admin_users(@ModelAttribute("search") String search, Model model) {
		model.addAttribute("title", "ADMIN USERS");
		model.addAttribute("USER", CurrentUser.user);
		model.addAttribute("messages", ErrorFetch.get_error_list());
		
		search = search.trim().strip();
		List<UserEntity> search_result = AdminServices_services.find_all_by_user_search(search.toUpperCase());
		model.addAttribute("users", search_result);
		model.addAttribute("count", search_result.size());
		
		if ( CurrentUser.user == null ) {
			ErrorFetch.add("Please Login");
			return "redirect:/logout";
		}
		
		if ( CurrentUser.user.isIs_superuser() == false ) {
			ErrorFetch.add("You are not authorized to Login");
			return "redirect:/logout";
		}		
		
		return "admin/users/admin_users";
	}
	

	
	
	@GetMapping("/admin/users/update/{user_id}")
	public String user_update_user_id(@PathVariable("user_id") Long user_id, Model model) {
		model.addAttribute("title", "ADMIN UPDATE USERS");
		model.addAttribute("USER", CurrentUser.user);
		
		if ( CurrentUser.user == null ) {
			ErrorFetch.add("Please Login");
			return "redirect:/logout";
		}
		
		if ( CurrentUser.user.isIs_superuser() == false ) {
			ErrorFetch.add("You are not authorized to Login");
			return "redirect:/logout";
		}	
		
		model.addAttribute("admin_user_update", AdminServices_services.get_user(user_id));
		model.addAttribute("messages", ErrorFetch.get_error_list());
		return "admin/users/admin_update_user";
	}
	
	
	
	
	@PostMapping("/admin/users/update/{user_id}")
	public String post_admin_users(@PathVariable("user_id") Long user_id, @Valid @ModelAttribute("admin_user_update") UserEntity admin_user_update, BindingResult result, Model model) {
		
		if ( AdminUserUpdateSave_validate.admin_user_update_save(admin_user_update, result, user_id) ) {
			ErrorFetch.add("User Details has been added successfully");
		}
		
		return "redirect:/admin/users/update/"+user_id;
	}		
		
	
	

	@GetMapping("/admin/users/delete/{user_id}")
	public String user_delete_user_id(@PathVariable("user_id") Long user_id) {
				
		if ( CurrentUser.user == null ) {
			ErrorFetch.add("Please Login");
			return "redirect:/logout";
		}
		
		if ( CurrentUser.user.isIs_superuser() == false ) {
			ErrorFetch.add("You are not authorized to Login");
			return "redirect:/logout";
		}	
		
		
		AdminServices_services.admin_user_delete(user_id);	
		ErrorFetch.add("User has been deleted Successfully");
		return "redirect:/admin/users";
	}
}
