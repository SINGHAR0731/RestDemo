package com.interview.demo.restdemo.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomNumberService {

	private final Integer MIN_VALUE = 1;
	private final Random random = new Random();

	public Integer getRandomValue (Integer value) {
		if (value <= MIN_VALUE) { // Stop -ive value;
			return MIN_VALUE;
		}
		return random.nextInt((value - MIN_VALUE) + 1) + MIN_VALUE;
	}
}