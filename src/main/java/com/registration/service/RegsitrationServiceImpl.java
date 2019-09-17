package com.registration.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.dto.RegistrationRequestDTO;
import com.registration.dto.RegistrationResponseDTO;
import com.registration.entity.Registration;
import com.registration.exception.DataNotFoundException;
import com.registration.repository.RegistrationRepository;
import com.registration.util.RegistrationUtil;

@Service

public class RegsitrationServiceImpl implements RegistrationService {

	@Autowired
	RegistrationRepository registrationRepository;
	@Autowired
	RegistrationUtil registrationUtil;

	public RegistrationResponseDTO register(RegistrationRequestDTO registrationRequestDTO) {

		RegistrationResponseDTO registrationResponseDTO = new RegistrationResponseDTO();

		Optional<Registration> register1 = registrationRepository.findByEmail(registrationRequestDTO.getEmail());

		if (Objects.isNull(register1)) {
			Registration register = new Registration();
			BeanUtils.copyProperties(registrationRequestDTO, register);
			String generatePassword = registrationUtil.generatePassword(registrationRequestDTO.getUserName());
			register.setPassword(generatePassword);
			registrationRepository.save(register);

			registrationResponseDTO.setMessage(RegistrationUtil.REGISTRATION_SUCCESS_MESSAGE);
			registrationResponseDTO.setStatus(RegistrationUtil.STATUS_SUCCESS);
			registrationResponseDTO.setRegistrationId(register.getRegistrationId());
		} else if (register1.isPresent()) {

			throw new DataNotFoundException(RegistrationUtil.REGISTRATION_ALREADY_DONE_MESSAGE);

		} else {
			throw new DataNotFoundException(RegistrationUtil.REGISTRATION_FAILURE_MESSAGE);
		}

		return registrationResponseDTO;
	}

}
