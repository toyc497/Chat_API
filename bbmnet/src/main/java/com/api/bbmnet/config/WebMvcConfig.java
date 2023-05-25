package com.api.bbmnet.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("GET","POST","DELETE","HEAD","OPTIONS").allowCredentials(false);
		
	}
	
}
