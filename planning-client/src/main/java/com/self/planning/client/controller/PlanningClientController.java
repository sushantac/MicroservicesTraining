package com.self.planning.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController("/")
public class PlanningClientController {

	@Autowired
	RestTemplate restTemplate;
	
	
	@RequestMapping(path="plan")
	public String getPlanningDesc() {
		
		return restTemplate.exchange("http://planning-service/plan", HttpMethod.GET, null, String.class).getBody();
	}
	
	@RequestMapping(path="course")
	public String getTrainingDesc() {
		
		return restTemplate.exchange("http://training-service/course", HttpMethod.GET, null, String.class).getBody();
	}
}
