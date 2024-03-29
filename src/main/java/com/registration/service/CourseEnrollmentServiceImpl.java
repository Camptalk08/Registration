package com.registration.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.registration.dto.CourseEnrollmentRequestDto;
import com.registration.dto.CourseEnrollmentResponseDto;
import com.registration.dto.EnrolledCourseDto;
import com.registration.dto.EnrolledCourseResponseDto;
import com.registration.entity.CourseEnrollment;
import com.registration.exception.CourseAlreadyExistException;
import com.registration.exception.NoAnyCourseEnrollException;
import com.registration.repository.CourseEnrollmentRepository;
import com.registration.util.CourseEnrollmentUtil;

/**
 * 
 * @author Sushil
 *
 */
@Service
public class CourseEnrollmentServiceImpl implements CourseEnrollmentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CourseEnrollmentServiceImpl.class);

	@Autowired
	CourseEnrollmentRepository CourseEnrollmentRepository;

	/**
	 * This method is use to enroll course for register user
	 * 
	 * @param CourseEnrollmentRequestDto ,not null
	 * @return CourseEnrollmentResponseDto
	 * @exception CourseAlreadyExistException throws if course id and register id
	 *                                        does not exist
	 */
	@Override
	public CourseEnrollmentResponseDto enrollCourseForUser(CourseEnrollmentRequestDto enrollmentRequestDto) {
		LOGGER.info("Inside enrollCourse method");
		CourseEnrollmentResponseDto responseDto;
		Optional<CourseEnrollment> courseEnroll = CourseEnrollmentRepository.findByCourseIdAndRegistrationId(
				enrollmentRequestDto.getCourseId(), enrollmentRequestDto.getRegistrationId());
		if (courseEnroll.isPresent()) {

			throw new CourseAlreadyExistException(CourseEnrollmentUtil.COURSE_ALREADY_EXIST_EXCEPTION);

		} else {
			CourseEnrollment courseEnrollment = new CourseEnrollment();
			BeanUtils.copyProperties(enrollmentRequestDto, courseEnrollment);
			courseEnrollment.setEnrollmentDate(LocalDate.now());

			CourseEnrollmentRepository.save(courseEnrollment);

			responseDto = new CourseEnrollmentResponseDto();
			responseDto.setMessage(CourseEnrollmentUtil.ENROLL_SUCCESS_MESSAGE);
			responseDto.setStatus(CourseEnrollmentUtil.STATUS_SUCCESS);

		}
		return responseDto;
	}

	/**
	 * This method is use to get all enrolled courses based on registration id
	 * @param registrationId ,not null
	 * @return List<EnrolledCourseResponseDto>
	 * @exception NoAnyCourseEnrollException throws if no registration id finds s
	 */
	@Override
	public List<EnrolledCourseResponseDto> getAllEnrolledCourse(int registrationId) {
		LOGGER.info("Inside getAllEnrolledCourse method");
		List<EnrolledCourseResponseDto> response;
		Optional<List<Integer>> courseEnroll = CourseEnrollmentRepository
				.findAllCourseIdByRegistrationId(registrationId);

		if (courseEnroll.isPresent()) {
			LOGGER.info("enroll data ={}", courseEnroll.get());
			RestTemplate restTemplate = new RestTemplate();
			StringBuilder sb = new StringBuilder("?");
			for(int ids : courseEnroll.get()) {
				sb.append("courseIds="+ids+"&");
			}
			String idUrl = sb.toString();
			idUrl = idUrl.substring(0, idUrl.lastIndexOf("&"));
			LOGGER.info("idUrl :: "+idUrl);
			 response =	restTemplate.exchange(CourseEnrollmentUtil.GET_ALL_COURSE_URI+idUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<EnrolledCourseResponseDto>>() {}).getBody();
			LOGGER.info("enroll data ={}", response);
		} else {
			throw new NoAnyCourseEnrollException(CourseEnrollmentUtil.NO_ANY_COURSE_ENROLL_EXCEPTION);
		}

		return response;
	}

	@Override
	public List<EnrolledCourseDto> getEnrolledCourse(int registrationId) {
		
		LOGGER.info("Inside getEnrolledCourse method");
		List<EnrolledCourseDto> response = new ArrayList<>();
		Optional<List<Integer>> courseEnroll = CourseEnrollmentRepository
				.findAllCourseIdByRegistrationId(registrationId);
     
		if (courseEnroll.isPresent()) {
			courseEnroll.get().forEach(cId->{
				EnrolledCourseDto courseDto = new EnrolledCourseDto();
				courseDto.setCourseId(cId);
				response.add(courseDto);
			});
	}
		else
		{
			throw new NoAnyCourseEnrollException(CourseEnrollmentUtil.NO_ANY_COURSE_ENROLL_EXCEPTION);
		}
		
		return response;

}
}
