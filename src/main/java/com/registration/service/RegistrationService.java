package com.registration.service;

import com.registration.dto.RegistrationRequestDTO;
import com.registration.dto.RegistrationResponseDTO;

public interface RegistrationService {

	RegistrationResponseDTO register(RegistrationRequestDTO registrationRequestDTO);

}
