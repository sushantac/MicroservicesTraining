package com.self.planning.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Configuration {
	
	@Value("${application.environment}")
	public String environment;
}
