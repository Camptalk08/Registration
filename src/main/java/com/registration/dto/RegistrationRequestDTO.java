package com.registration.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequestDTO {

	@NotEmpty(message = "User name can't be empty.")
	private String userName;
	private long phone;
	@NotEmpty(message = "Email id is mandatory.")
	private String email;
}
