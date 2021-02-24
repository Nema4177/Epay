package com.example.producingwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.ValidateCreditCardDetailsRequest;
import io.spring.guides.gs_producing_web_service.ValidateCreditCardDetailsResponse;

@Endpoint
public class ValidateCreditCardDetailsEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private ValidateCreditCardDetailsRepository validateCrediCardDetailsRepository;

	@Autowired
	public ValidateCreditCardDetailsEndpoint(ValidateCreditCardDetailsRepository countryRepository) {
		this.validateCrediCardDetailsRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "validateCreditCardDetailsRequest")
	@ResponsePayload
	public ValidateCreditCardDetailsResponse getCountry(@RequestPayload ValidateCreditCardDetailsRequest request) {
		ValidateCreditCardDetailsResponse response = new ValidateCreditCardDetailsResponse();
		response.setIsValid(validateCrediCardDetailsRepository.validateCreditCard());

		return response;
	}
}