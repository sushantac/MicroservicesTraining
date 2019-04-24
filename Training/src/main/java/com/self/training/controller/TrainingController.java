package com.self.training.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.self.training.model.Course;

@RestController
public class TrainingController {
	
	@RequestMapping(path="/")
	public String  getApplicationName() {
		return "This is coming from TRAINING application!";
	}

	
	@RequestMapping(path="/course")
	public List<Course>  getCourses() {
		List<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("Linux");
		courses.add("SAS");
		
		List<Course> courseObjects = new ArrayList<Course>();
		courses.forEach(course -> {

			courseObjects.add(new Course(courseObjects.size() + 1, course, course + " description", courseObjects.size() + 1));

		});
		
		return courseObjects;
	}

}
