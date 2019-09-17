package com.registration.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.dto.CourseEnrollmentRequestDto;
import com.registration.dto.CourseEnrollmentResponseDto;
import com.registration.dto.EnrolledCourseResponseDto;
import com.registration.service.CourseEnrollmentService;

/**
 * 
 * @author Sushil
 *
 */
@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class CourseEnrollmentController {
	
	private static final Logger LOGGER  =LoggerFactory.getLogger(CourseEnrollmentController.class);
	
	@Autowired
	CourseEnrollmentService courseEnrollmentService;
	/**
	 * This method is use to enroll course of registered user
	 * @param courseEnrollmentRequestDto ,not null
	 * @return CourseEnrollmentResponseDto
	 */
	@PostMapping("/courses/enrollments")
	public ResponseEntity<CourseEnrollmentResponseDto> enrollCourse(@RequestBody CourseEnrollmentRequestDto courseEnrollmentRequestDto)
	{
		LOGGER.info("Inside enrollCourse method");
		CourseEnrollmentResponseDto response =courseEnrollmentService.enrollCourseForUser(courseEnrollmentRequestDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	/**
	 * This method is use to get all enrolled course of registered user
	 * @param registrationId,not null
	 * @return List<EnrolledCourseResponseDto>, not null
	 */
	@GetMapping("/courses/{registrationId}/enrollments")
	public ResponseEntity<List<EnrolledCourseResponseDto>> getAllEnrolledCourse(@PathVariable Integer registrationId){
		
		LOGGER.info("CourseController :: getAllEnrolledCourse --- ");
		List<EnrolledCourseResponseDto> response  =courseEnrollmentService.getAllEnrolledCourse(registrationId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
