package com.api.bbmnet.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.bbmnet.form.BotRequestForm;

@Service
public class ApiBotService {
	
	public String getMessagesPregao(BotRequestForm botForm) {
		
		String botUrl = "http://localhost:5000/bbmnet";
		
		RestTemplate restTemplate = new RestTemplate();
		String messageResponse = restTemplate.postForObject(botUrl, botForm, String.class);
		
		return messageResponse;
		
	}
	
}
