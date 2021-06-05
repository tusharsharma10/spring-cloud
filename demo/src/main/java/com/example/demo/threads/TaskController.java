package com.example.demo.threads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

	@Autowired 
	private TaskDistributor service;
	
	@GetMapping("/")
	public void distribute() {
		
		service.distribute();
	}
	
}
