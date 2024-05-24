package com.bussiness.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bussiness.webapp.current_user.CurrentUser;
import com.bussiness.webapp.error.ErrorFetch;
import com.bussiness.webapp.user.entity.UserEntity;
import com.bussiness.webapp.validate.user.UserProfileSaveValidate;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	UserProfileSaveValidate UserProfileSaveValidate_validate;
	
    //	Home Route
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "HOME");
		model.addAttribute("USER", CurrentUser.user);
		model.addAttribute("messages", ErrorFetch.get_error_list());
		
		if ( CurrentUser.user == null ) {
			ErrorFetch.add("Please Login");
			return "redirect:/logout";
		}
		
		return "main/home";
	}
	
	
	
	
	//  About Route
	@GetMapping("/about") 
	public String about(Model model) {
		model.addAttribute("title", "ABOUT");
		model.addAttribute("USER", CurrentUser.user);
		
		if ( CurrentUser.user == null ) {
			ErrorFetch.add("Please Login");
			return "redirect:/logout";
		}
		
		return "main/about";
	}
	
	
	
	
	@GetMapping("/profile")
	public String get_profile(Model model) {
		model.addAttribute("title", "PROFILE");
		model.addAttribute("USER", CurrentUser.user);
		model.addAttribute("messages", ErrorFetch.get_error_list());
		
		if ( CurrentUser.user == null ) {
			ErrorFetch.add("Please Login");
			return "redirect:/logout";
		}
				
		return "main/profile";
	}
	
	
	@PostMapping("/profile")
	public String post_profile(@Valid @ModelAttribute("USER") UserEntity USER, BindingResult result, Model model) {
		
		if ( UserProfileSaveValidate_validate.user_profile_save(USER, result) ) {
			ErrorFetch.add("Profile has been updated successfully");
			return "redirect:/profile";
		}
		
		return "redirect:/profile";
	}
}
