package com.registration.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registration.entity.CourseEnrollment;
@Repository
public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, Integer> {
	
	@Query(value = "select courseId from CourseEnrollment where registrationId= :registrationId")
	public Optional<List<Integer>> findAllCourseIdByRegistrationId(int registrationId);
	
	public Optional<CourseEnrollment> findByCourseIdAndRegistrationId(int courseId,int registrationId);

}
