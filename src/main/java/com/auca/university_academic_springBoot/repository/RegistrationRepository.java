package com.auca.university_academic_springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auca.university_academic_springBoot.model.Registration;

@Repository 
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
