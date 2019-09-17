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
			RegistrationResponseDTO  registrationResponseDTO= new RegistrationResponseDTO();
			registrationResponseDTO.setMessage("SUCCESS");
			registrationResponseDTO.setRegistrationId(1);
			registrationResponseDTO.setStatus("Success");
			
			
			return registrationResponseDTO;
		}

	/*
	 * @Test public void getLeaveHistoryController() {
	 * ResponseEntity<List<LeaveHistoryResponseDTO>> expResult = new
	 * ResponseEntity<>(getAllLeaveHistoryTest(), HttpStatus.OK);
	 * when(leaveHistoryService.getAllLeaveHistory(Mockito.anyInt(),
	 * Mockito.anyInt(), Mockito.anyString(),
	 * Mockito.anyString())).thenReturn(getAllLeaveHistoryTest());
	 * ResponseEntity<List<LeaveHistoryResponseDTO>> actResult =
	 * leaveHistoryController.getAllLeaveHistory(1, 2, "2019-08-12", "2019-08-16");
	 * assertEquals(expResult.getStatusCode(), actResult.getStatusCode()); }
	 */

}
