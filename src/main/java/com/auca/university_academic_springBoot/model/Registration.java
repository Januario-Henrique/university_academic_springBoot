package com.auca.university_academic_springBoot.model;

import java.time.LocalDate;

import com.auca.university_academic_springBoot.model.enums.EResgitrationStatus;

import jakarta.persistence.*;

@Entity
@Table(
    name = "registrations",
    uniqueConstraints = @UniqueConstraint(
        name = "uk_registration_student_course_term",
        columnNames = {"student_id", "course_id", "academic_year", "semester"}
    )
)
public class Registration {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private LocalDate registrationDate;

    @Column (nullable = false)
    private String academicYear;

    @Column (nullable = false)
    private EResgitrationStatus status;

    @Column (nullable = false)
    private Double grade;

    
    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "student_id", nullable = false)
    private Student student;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "course_id", nullable = false)
    private Course courses;

    public Registration() {
    }

    public Registration(Long id, LocalDate registrationDate, String academicYear, EResgitrationStatus status,
            Double grade, Student student, Course courses) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.academicYear = academicYear;
        this.status = status;
        this.grade = grade;
        this.student = student;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public EResgitrationStatus getStatus() {
        return status;
    }

    public void setStatus(EResgitrationStatus status) {
        this.status = status;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }

    
    



}
