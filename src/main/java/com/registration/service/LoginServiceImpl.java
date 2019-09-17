package com.registration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.dto.LoginDto;
import com.registration.dto.LoginResponseDto;
import com.registration.entity.Registration;
import com.registration.exception.DataNotFoundException;
import com.registration.repository.RegistrationRepository;

/**
 * @author Laxman
 * @date 17 Sept 2019
 * 
 *       This service for validation and user login
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private RegistrationRepository loginRepository;

	@Override
	public LoginResponseDto userLogin(LoginDto loginDto) {
		Optional<Registration> loginDetails = loginRepository.findByEmail(loginDto.getEmail());
		LoginResponseDto loginResponseDto = null;
		if (!loginDetails.isPresent()) {
			throw new DataNotFoundException("Record Not Found with email " + loginDto.getEmail());
		}

		Registration registration = loginDetails.get();
		if (loginDto.getPasswords().equals(registration.getPassword())) {
			loginResponseDto = LoginResponseDto.builder().userName(registration.getUserName())
					.registrationIdl(registration.getRegistrationId()).status("success").message("Login successfully.")
					.build();
		} else {
			loginResponseDto = LoginResponseDto.builder().status("Failed").message("Login failed.").build();
		}
		return loginResponseDto;
	}

}
