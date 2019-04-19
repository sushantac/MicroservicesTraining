package com.self.planning.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.self.planning.config.Configuration;

@RestController
public class PlanningController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Configuration configuration;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getApplicationName() {
		return "This is coming from planning application!";
	}
	
	@RequestMapping(path = "/environment", method = RequestMethod.GET)
    public String getEnvironment(@Value("${application.environment}") String environment) {
        return environment;
    }
    
	@RequestMapping(path = "/env", method = RequestMethod.GET)
    public String getEnvironment() {
        return configuration.environment;
    }
	
	@RequestMapping(path = "/planning", method = RequestMethod.GET)
	public String getTrainingCourses() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String ret = restTemplate.exchange("http://training-service/courses", HttpMethod.GET, entity, String.class).getBody();
		System.out.println("\n\n return : " + ret);
		return ret;
	}

}
