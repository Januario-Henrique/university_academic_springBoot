package com.auca.university_academic_springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auca.university_academic_springBoot.model.Student;

@Repository 
public interface StudentRepository extends JpaRepository<Student, Long>{

}
