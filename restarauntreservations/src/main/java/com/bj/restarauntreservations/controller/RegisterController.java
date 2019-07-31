package com.bj.restarauntreservations.controller;

import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bj.restarauntreservations.model.User;

@Controller
public class RegisterController {
	
	@Autowired
	private UserDetailsManager userDetailsManager;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ResponseEntity<String> registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return new ResponseEntity<String>("Error", HttpStatus.INTERNAL_SERVER_ERROR); //this needs to return error
		}
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		Collection<? extends GrantedAuthority> roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
		
		UserDetails userDetails = new User(user.getUsername(), hashedPassword, roles);
		userDetailsManager.createUser(userDetails);
		return new ResponseEntity<String>("Registration Success",HttpStatus.OK);
		
	}
	
}
