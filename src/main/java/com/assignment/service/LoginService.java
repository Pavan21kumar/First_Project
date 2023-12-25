package com.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assignment.entity.User;
import com.assignment.exception.PasswordMissMatchException;
import com.assignment.exception.WeekPasswordException;
import com.assignment.repository.LoginRepository;
import com.assignment.util.ResponseStructure;

@Service
public class LoginService {

	@Autowired
	private LoginRepository dao;

	@Autowired
	private ResponseStructure<User> structure;

	public ResponseEntity<ResponseStructure<User>> login(User user) {

		int capital = 0;
		int special = 0;
		int number = 0;
		String password = user.getPassword();
		if (password.equals(user.getConfirmPassword())) {
			if (password.length() >= 8) {
				for (int i = 0; i < password.length(); i++) {

					if (password.charAt(i) >= 65 && password.charAt(i) <= 90) {
						capital++;
					}
					if (password.charAt(i) >= 33 && password.charAt(i) <= 47
							|| password.charAt(i) >= 91 && password.charAt(i) <= 96
							|| password.charAt(i) >= 123 && password.charAt(i) <= 126) {
						special++;
					}
					if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
						number++;
					}
				}
//				System.out.println("number of capital "+capital+" number of numbers "+number+" number of special characters "+special);
				if (capital >= 1 && special >= 1 && number >= 1) {
					dao.save(user);
					structure.setStatus(HttpStatus.CREATED.value());
					structure.setMessage("user is login........");
					structure.setData(user);
					return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
				} else {
					throw new WeekPasswordException(
							"password have must be one Special Character and One Numaric and One capital ....");
				}
			} else {
				throw new WeekPasswordException("password must be more then 8 characters.!!!!!!");
			}
		} else {
			throw new PasswordMissMatchException("password and confirmdPassword Should be Same..........");
		}
	}

}
