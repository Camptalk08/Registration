package com.registration.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.registration.dto.RegistrationRequestDTO;
import com.registration.dto.RegistrationResponseDTO;
import com.registration.entity.Registration;
import com.registration.exception.DataNotFoundException;
import com.registration.repository.RegistrationRepository;
import com.registration.util.RegistrationUtil;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceImplTest {

	@Mock
	RegistrationRepository registrationRepository;

	@Mock
	RegistrationUtil registrationUtil;

	@InjectMocks
	RegsitrationServiceImpl regsitrationServiceImpl;
	Registration registration;
	RegistrationRequestDTO registrationRequestDTO;
	RegistrationResponseDTO registrationResponseDTO;
	String password;

	@Before
	public void init() {

		registrationResponseDTO = new RegistrationResponseDTO();
		registrationResponseDTO.setMessage("Registered Successfully");
		registrationResponseDTO.setRegistrationId(1);
		registrationResponseDTO.setStatus("Registered Successfully");

		registration = new Registration();
		registration.setEmail("765756");
		registration.setPassword("uty768");
		registration.setPhone(9896976);
		registration.setRegistrationId(1);
		registration.setUserName("Ajith");

		registrationRequestDTO = new RegistrationRequestDTO();
		registrationRequestDTO.setEmail("Ajith");
		registrationRequestDTO.setPhone(98876);
		registrationRequestDTO.setUserName("hfhfg");

		password = registrationUtil.generatePassword("Ajith");

	}

	@Test
	public void registerTest() {
		Mockito.when(registrationRepository.findByEmail(registrationRequestDTO.getEmail())).thenReturn(null);

		RegistrationResponseDTO acctualResult = regsitrationServiceImpl.register(registrationRequestDTO);
		assertEquals("Success", acctualResult.getStatus());
		assertEquals(0, acctualResult.getRegistrationId());
		assertEquals("Registered Successfully", acctualResult.getMessage());
	}

	@Test(expected = DataNotFoundException.class)
	public void dataNotFoundException() {

		Mockito.when(registrationRepository.findByEmail(Mockito.anyString())).thenReturn(registration);
		RegistrationResponseDTO acctualResult = regsitrationServiceImpl.register(registrationRequestDTO);
		assertEquals("Failed", acctualResult.getStatus());
	}

}
