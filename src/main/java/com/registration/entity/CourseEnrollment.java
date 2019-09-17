package com.registration.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Sushil
 *
 */
@Entity
@Table
@Setter
@Getter
public class CourseEnrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseEnrollmentId;
	private int courseId;
	private int registrationId;
	private LocalDate enrollmentDate;

}
