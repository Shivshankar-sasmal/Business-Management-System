package com.bussiness.webapp.error;

import java.util.ArrayList;

import org.springframework.stereotype.Service;



@Service
public class ErrorFetch {
	static ArrayList<String> error_temprary_list = new ArrayList<>();
	
	public static void add(String message) {
		error_temprary_list.add(message);
	}
	
	
	public static int error_list_count() {
		return error_temprary_list.size();
	}
	
	
	public static ArrayList<String> get_error_list() {
		ArrayList<String> error_list = new ArrayList<>();
		error_list.addAll(error_temprary_list);
		error_temprary_list.clear();
		return error_list;
	}
}