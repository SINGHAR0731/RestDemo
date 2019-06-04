package com.interview.demo.restdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interview.demo.restdemo.service.RandomNumberService;

@RestController
@RequestMapping("/random")
public class RandomRestController {
	
	@Autowired
	private RandomNumberService randomNumberService;
		
	@GetMapping(path = "/number") 
	public Integer getNumber(@RequestParam(name = "value", defaultValue = "6", required = false) Integer value) {
			return randomNumberService.getRandomValue(value);			
	}
}