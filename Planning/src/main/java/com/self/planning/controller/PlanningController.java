package com.self.planning.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.self.planning.config.Configuration;
import com.self.planning.model.Course;
import com.self.planning.model.Plan;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/planning", produces = "application/json")
@RequestMapping("/planning")
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

	@ApiOperation(value = "getPlan", response = Plan.class)
	@ApiResponses(value = 
			{ 
			  @ApiResponse(code = 200, message = "Plan Details Retrieved", response = Plan.class),
			  @ApiResponse(code = 500, message = "Internal Server Error"),
			  @ApiResponse(code = 404, message = "Plan not found") 
			}
	)
	@RequestMapping(path = "/plan/{id}", method = RequestMethod.GET)
	public Plan getPlan(@PathVariable("id") Integer id) {

		Plan p = new Plan();
		p.setId(id);
		p.setName("Plan" + id);
		p.setDescription("This is plan " + id);
		p.setCourses(new ArrayList<Course>());
		
		Course c = new Course();
		c.setId(1);
		c.setName(p.getName() + "_Course_1");
		p.getCourses().add(c);
		
		System.out.println("\n\n returnPlan : " + p);

		return p;
	}

	@RequestMapping(path = "/courses", method = RequestMethod.GET)
	public String getTrainingCourses() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String ret = restTemplate.exchange("http://training-service/courses", HttpMethod.GET, entity, String.class).getBody();
		
		System.out.println("\n\n return : " + ret);
		return ret;
	}

}
