package com.registration.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RegistrationUtil {
	
	public static final String REGISTRATION_SUCCESS_MESSAGE= "Registered Successfully";
	public static final String REGISTRATION_FAILURE_MESSAGE= "Registration Failed";
	public static final String REGISTRATION_ALREADY_DONE_MESSAGE= "Email is already used";

	public static final String STATUS_SUCCESS = "Success";

	public static final String STATUS_FAILURE = "Failed";

	
	public String generatePassword(String userName)
	{
		return userName+new Random().nextInt(10000);
	}

}
