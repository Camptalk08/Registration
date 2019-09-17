package com.registration.service;

import java.util.List;

import com.registration.dto.CourseEnrollmentRequestDto;
import com.registration.dto.CourseEnrollmentResponseDto;
import com.registration.dto.EnrolledCourseResponseDto;
/**
 * 
 * @author Sushil
 *
 */
public interface CourseEnrollmentService {
	
	public CourseEnrollmentResponseDto enrollCourseForUser(CourseEnrollmentRequestDto enrollmentRequestDto);
	
	public List<EnrolledCourseResponseDto> getAllEnrolledCourse(int registrationId);

}
