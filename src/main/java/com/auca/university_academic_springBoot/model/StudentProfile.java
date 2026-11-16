package com.auca.university_academic_springBoot.model;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name= "student_profiles")
public class StudentProfile {
    @Id 
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column (nullable= false, length = 20)
    private String gender;

    @Column (name = "phone_number", length = 30)
    private String phoneNumber;
    
    @Column (length = 255)
    private String address;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "student_id", nullable = false, unique= true)
    private Student student;

    public StudentProfile() {
    }

    public StudentProfile(Long id, Date dateOfBirth, String gender, String phoneNumber, String address,
            Student student) {
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    

}
