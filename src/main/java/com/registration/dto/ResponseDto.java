package com.registration.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDto {
	private Long loginId;
	private Long regId;
	private String email;
	private String password;
}
