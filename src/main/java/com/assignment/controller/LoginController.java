package com.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entity.User;
import com.assignment.service.LoginService;
import com.assignment.util.ResponseStructure;

@RestController
@RequestMapping("/login")
public class LoginController {

	
	@Autowired
	private LoginService service;
	
	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<User>> login(@RequestBody User user)
	{
		return service.login(user);
	}
}
