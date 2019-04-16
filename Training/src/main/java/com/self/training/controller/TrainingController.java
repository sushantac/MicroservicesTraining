package com.self.training.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingController {
	
	@RequestMapping(path="/")
	public String  getApplicationName() {
		return "This is coming from training application!";
	}

	
	@RequestMapping(path="/courses")
	public String  getCourses() {
		return "The available courses are - Java, Linux and SAS!!!";
	}

}
