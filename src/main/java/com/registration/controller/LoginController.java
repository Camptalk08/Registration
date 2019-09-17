package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.dto.LoginDto;
import com.registration.dto.LoginResponseDto;
import com.registration.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> userLogin(@RequestBody LoginDto loginDto){
		
		log.info("LoginController :: userLogin ----");
		return new ResponseEntity<>(loginService.userLogin(loginDto), HttpStatus.OK);
	}
}
