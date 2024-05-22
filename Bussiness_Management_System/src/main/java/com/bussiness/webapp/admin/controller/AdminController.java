package com.bussiness.webapp.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bussiness.webapp.admin.DTO.AdminUsersDTO;
import com.bussiness.webapp.current_user.CurrentUser;
import com.bussiness.webapp.error.ErrorFetch;
import com.bussiness.webapp.user.entity.UserEntity;

@Controller
@RequestMapping("/")
public class AdminController {
	@Autowired
	AdminUsersDTO AdminUsersDTO_dto;
	
	
	@GetMapping("/admin/users")
	public String admin_users(@ModelAttribute("search") String search, Model model) {
		model.addAttribute("title", "ADMIN USERS");
		model.addAttribute("USER", CurrentUser.user);
		
		search = search.trim().strip();
		List<UserEntity> search_result = AdminUsersDTO_dto.findAllBySearch(search.toUpperCase());
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
	
	
	
	@GetMapping("/admin/company")
	public String admin_company(@ModelAttribute("search") String search, Model model) {
		model.addAttribute("title", "ADMIN USERS");
		model.addAttribute("USER", CurrentUser.user);
		
		search = search.trim().strip();
		List<UserEntity> search_result = AdminUsersDTO_dto.findAllBySearch(search.toUpperCase());
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
		
		return "admin/admin_company";
	}
}
