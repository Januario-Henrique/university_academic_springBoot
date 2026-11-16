package com.auca.university_academic_springBoot.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "student")
public class Student {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "first_name", nullable = false, length = 100)
    private String firstName;
    @Column (name = "last_name", nullable = false, length = 100)
    private String lastName;
    @Column (name = "first_name", nullable = false,unique = true, length = 30)
    private String studentNumber;
    @Column (name="email", unique = true, length = 150)
    private String email;

    @ManyToOne (fetch= FetchType.LAZY, optional = false) 
    @JoinColumn (name = "department_id", nullable = false)
    private Department department;

    @OneToOne (mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private StudentProfile profile;

    @OneToMany (mappedBy= "student")
    private List<Registration> registration= new ArrayList<>();

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, String studentNumber, String email,
            Department department, StudentProfile profile, List<Registration> registration) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.email = email;
        this.department = department;
        this.profile = profile;
        this.registration = registration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public StudentProfile getProfile() {
        return profile;
    }

    public void setProfile(StudentProfile profile) {
        this.profile = profile;
    }

    public List<Registration> getRegistration() {
        return registration;
    }

    public void setRegistration(List<Registration> registration) {
        this.registration = registration;
    }

    

}
