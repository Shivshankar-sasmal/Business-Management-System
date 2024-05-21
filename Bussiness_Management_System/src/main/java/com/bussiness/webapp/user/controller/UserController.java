package com.bussiness.webapp.user.controller;

import com.bussiness.webapp.user.service.UserService;
import com.bussiness.webapp.user.validate.UserLoginValidate;
import com.bussiness.webapp.user.validate.UserRegisterSaveValidate;
import com.bussiness.webapp.current_user.CurrentUser;
import com.bussiness.webapp.error.ErrorFetch;
import com.bussiness.webapp.user.entity.UserEntity;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserService UserService_service;
	
	@Autowired
	UserRegisterSaveValidate UserRegisterSaveValidate_validate;
	
	
	@Autowired
	UserLoginValidate UserLoginValidate_validate;
	
	
	@GetMapping("/register")
	public String get_register(Model model) {
		model.addAttribute("TITLE", "REGISTER");
		model.addAttribute("USER", CurrentUser.user);
		model.addAttribute("user_register", UserService_service.create_new_user());
		return "authenticate/register";
	}
	
	
	@PostMapping("/register") 
	public String post_register(@Valid @ModelAttribute("user_register") UserEntity user_register, BindingResult result, Model model) {
		
		if ( UserRegisterSaveValidate_validate.user_register_save_validate(user_register, result ) ) {
			ErrorFetch.add("Account has been created successfully");
			return "redirect:/login";
		}
		
		model.addAttribute("messages", ErrorFetch.get_error_list());		
		return "authenticate/register";
	}
	
	
	
	
	
	@GetMapping("/login")
	public String get_login(Model model) {		
		model.addAttribute("USER", CurrentUser.user);
		model.addAttribute("messages", ErrorFetch.get_error_list());
		
		return "authenticate/login";
	}
	
	
	
	@PostMapping("/login")
	public String post_login(@ModelAttribute("username") String username, @ModelAttribute("password") String password,Model model) {
		model.addAttribute("title", "LOGIN");
		
		if ( UserLoginValidate_validate.user_login_validate(username, password) ) {
			ErrorFetch.add("You have logged in Successfully");
			return "redirect:/";
		}
		
		ErrorFetch.add("Username or Password is Incorrect");		
		return "redirect:/login";
	}
	

	@GetMapping("/logout")
	public String logout(Model model) {
		ErrorFetch.add("Have a Nice Day");
		CurrentUser.set_user(null);
		return "redirect:/login";
	}
}
