package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.dto.RegistrationRequestDTO;
import com.registration.dto.RegistrationResponseDTO;
import com.registration.service.RegistrationService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@Slf4j
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	/**
	 * This method is use to Register the User @param registrationRequestDTO,not
	 * null @return RegistrationResponseDTO,not null @exception
	 */
	@PostMapping("/users")
	public ResponseEntity<RegistrationResponseDTO> register(
			@RequestBody RegistrationRequestDTO registrationRequestDTO) {
		log.info("Inside register method of RegistrationController class");
		RegistrationResponseDTO response = registrationService.register(registrationRequestDTO);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
