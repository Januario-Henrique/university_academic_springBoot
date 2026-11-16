package com.auca.university_academic_springBoot.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity 
@Table( name = "courses")
public class Course {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, unique = true, length = 20)
    private String code;

    @Column (nullable = false, length = 150)
    private String title;
    
    @Column (nullable = false)
    private Integer credits;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name= "department_id", nullable = false)
    private Department department;

    @ManyToMany(mappedBy = "courses")
    private Set<Lecturer> lecturers = new HashSet<>();

    @OneToMany (mappedBy = "courses")
    private List<Registration> registration = new ArrayList<>();

    public Course() {
    }

    public Course(Long id, String code, String title, Integer credits, Department department, Set<Lecturer> lecturers,
            List<Registration> registration) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.department = department;
        this.lecturers = lecturers;
        this.registration = registration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(Set<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public List<Registration> getRegistration() {
        return registration;
    }

    public void setRegistration(List<Registration> registration) {
        this.registration = registration;
    }

    


}
