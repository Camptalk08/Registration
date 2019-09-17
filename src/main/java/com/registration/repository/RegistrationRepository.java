package com.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registration.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer>{

	Optional<Registration> findByEmail(String email);


}
