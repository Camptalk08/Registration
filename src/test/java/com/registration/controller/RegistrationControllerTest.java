package com.registration.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.registration.dto.RegistrationRequestDTO;
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
	RegistrationRequestDTO registrationRequestDTO;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
		registrationRequestDTO = new RegistrationRequestDTO();
		registrationRequestDTO.setEmail("ayyanar@hcl.com");
		registrationRequestDTO.setPhone(78979778);
		registrationRequestDTO.setUserName("AYYANAR");
	}

	public RegistrationResponseDTO registerTests() {
		RegistrationResponseDTO registrationResponseDTO = new RegistrationResponseDTO();
		registrationResponseDTO.setMessage("SUCCESS");
		registrationResponseDTO.setRegistrationId(1);
		registrationResponseDTO.setStatus("Success");
		return registrationResponseDTO;

	}

	@Test
	public void getLeaveHistoryController() {
		ResponseEntity<RegistrationResponseDTO> expResult = new ResponseEntity<>(registerTests(), HttpStatus.OK);
		when(registrationService.register(Mockito.any())).thenReturn(registerTests());
		ResponseEntity<RegistrationResponseDTO> actResult = registrationController.register(registrationRequestDTO);
		assertEquals(201, actResult.getStatusCode().value());
		assertEquals(expResult.getBody().getRegistrationId(), actResult.getBody().getRegistrationId());
	}

}
