package com.example.producingwebservice;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class ValidateCreditCardDetailsRepository {
	private static final Map<Integer, String> responseRepo = new HashMap<>();

	@PostConstruct
	public void initData() {
		responseRepo.put(0, "yes");
		responseRepo.put(1, "no");
	}

	public String validateCreditCard() {
		Random rand = new Random(); 
        int randomInt = rand.nextInt(100); 
        if(randomInt < 95) {
        	return "yes";
        }else {
        	return "no";
        }
	}
}