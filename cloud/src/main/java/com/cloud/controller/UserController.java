package com.cloud.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.entity.aerospike.User;
import com.cloud.repository.aerospike.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	/**
	 * this is giving 500 error due to aerospike
	 */
	@GetMapping("/get/all")
	public List<User> getAllUsers() {

		return StreamSupport.stream(userRepository.findAll().spliterator(), false)
							.collect(Collectors.toList());
		
	}
	
	
	@GetMapping("/get/{id}")
	public User getUser(@PathVariable Integer id) {
		
		return userRepository.findById(id).get();
	}
	
	
	@PostMapping("/save")
	public void save(@RequestBody User u) {
		
		userRepository.save(u);
	}
	
}
