package com.bussiness.webapp.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bussiness.webapp.current_user.CurrentUser;
import com.bussiness.webapp.error.ErrorFetch;
import com.bussiness.webapp.user.entity.UserEntity;
import com.bussiness.webapp.admin.services.AdminServices;

@Controller
@RequestMapping("/")
public class AdminController {
	@Autowired
	AdminServices AdminServices_services;
	
	
	@GetMapping("/admin/users")
	public String admin_users(@ModelAttribute("search") String search, Model model) {
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
		
		return "admin/admin_users";
	}
	
	
	
	
	@GetMapping("/admin/user/update/{user_id}")
	public String user_update_user_id(@PathVariable("user_id") Long user_id) {
		return "admin/admin_users";
	}
	
	
	
	
	@GetMapping("/admin/user/delete/{user_id}")
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
	
	
	
	
	@GetMapping("/admin/company")
	public String admin_company(@ModelAttribute("search") String search, Model model) {
		model.addAttribute("title", "ADMIN COMPANY");
		model.addAttribute("USER", CurrentUser.user);
				
		if ( CurrentUser.user == null ) {
			ErrorFetch.add("Please Login");
			return "redirect:/logout";
		}
		
		if ( CurrentUser.user.isIs_superuser() == false ) {
			ErrorFetch.add("You are not authorized to Login");
			return "redirect:/logout";
		}		
		
		return "admin/admin_company";
	}
}
