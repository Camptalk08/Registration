package com.registration.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.registration.dto.RegistrationResponseDTO;
import com.registration.service.RegistrationService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class RegistrationControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	RegistrationController registrationController;

	@Mock
	RegistrationService registrationService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
	}

	public RegistrationResponseDTO registerTests() {
		RegistrationResponseDTO registrationResponseDTO = new RegistrationResponseDTO();
		registrationResponseDTO.setMessage("SUCCESS");
		registrationResponseDTO.setRegistrationId(1);
		registrationResponseDTO.setStatus("Success");

		return registrationResponseDTO;
	}

}