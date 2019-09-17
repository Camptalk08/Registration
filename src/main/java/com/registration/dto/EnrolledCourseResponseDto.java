package com.registration.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Sushil
 *
 */
@Setter
@Getter
public class EnrolledCourseResponseDto {

	private String courseName;
	private int courseDuration;
	private double courseFee;
	private String description;
}
