package com.bussiness.webapp.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bussiness.webapp.current_user.CurrentUser;
import com.bussiness.webapp.error.ErrorFetch;

@Controller
@RequestMapping("/")
public class CompanyController {

	@GetMapping("/register_company")
	public String user_register_company(Model model) {
		model.addAttribute("title", "REGISTER COMPANY");
		
		if ( CurrentUser.user == null ) {
			ErrorFetch.add("Please Login");
			return "redirect:/logout";
		}
		
		return "company/company_register";
	}
}
