package com.mail.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private RestTemplate restTemplate;
	
	
	public Map<String, Object> fetch() {
		Map<String, Object> resultMap = new HashMap<>();
		HttpHeaders headers = new HttpHeaders();
		String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2ODY1NTE4MDgsImNvbXBhbnlOYW1lIjoiVHJhaW5DbHViIiwiY2xpZW50SUQiOiIxNjFhNDc2OS02NmJmLTRlNDgtOWMyYy1iM2MyZmM5YWU1MTMiLCJvd25lck5hbWUiOiIiLCJvd25lckVtYWlsIjoiIiwicm9sbE5vIjoiMjAwMDAzMDE5OCJ9.okYSEg-Xw9VyuZdr4URckHClqhFnRJcMXI6zp_rstJk";
		headers.set("Authorization", "Bearer "+token);
//		headers.set("Other-Header", "othervalue");

		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		
		//restTemplate.getForEntity("http://104.211.219.98/train/trains", null)
		ResponseEntity<String> response = restTemplate.exchange(
				"http://104.211.219.98/train/trains", HttpMethod.GET, requestEntity, String.class);
		resultMap.put("response", response);
		return resultMap;
	}

//	public Map<String, Object> fetch() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}