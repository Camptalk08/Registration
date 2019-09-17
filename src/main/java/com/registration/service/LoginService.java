package com.registration.service;

import com.registration.dto.LoginDto;
import com.registration.dto.LoginResponseDto;

/**
 * @author Laxman
 *
 */
public interface LoginService {

	LoginResponseDto userLogin(LoginDto loginDto);

}
