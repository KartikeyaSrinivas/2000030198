package com.mail.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.demo.Service;

@RestController
public class Controller {

	@Autowired
	Service srvc;
	
	@GetMapping("/fetch")
	public Map<String, Object> fetchAllTrains(){
	Map<String, Object> resultMap = new HashMap<>();
	resultMap = srvc.fetch();
	return resultMap;
	}
}