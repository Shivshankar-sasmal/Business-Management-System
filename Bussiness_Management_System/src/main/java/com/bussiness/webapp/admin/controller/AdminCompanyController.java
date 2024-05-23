package com.bussiness.webapp.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bussiness.webapp.current_user.CurrentUser;
import com.bussiness.webapp.error.ErrorFetch;

@Controller
@RequestMapping("/")
public class AdminCompanyController {
	
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
		
		return "admin/company/admin_company";
	}
}
