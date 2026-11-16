package com.auca.university_academic_springBoot.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity 
@Table (name = "lecturers")
public class Lecturer {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "first_name", nullable = false)
    private String firstName;
     @Column (name = "last_name", nullable = false)
    private String lastName;

    @Column (unique = true, nullable = false)
    private String email;

    @OneToOne (mappedBy = "head")
    private Department headDepartment;

    @ManyToOne (fetch = FetchType.LAZY) 
    @JoinColumn (name = "department_id", nullable = false)
    private Department department;

    @ManyToMany
    @JoinTable (
        name = "lecturer_courses",
        joinColumns = @JoinColumn ( name = "lecturer_id"),
        inverseJoinColumns = @JoinColumn (name = "course_id")
    )
    private Set<Course> course = new HashSet<>();

    public Lecturer() {
    }

    public Lecturer(Long id, String firstName, String lastName, String email, Department headDepartment,
            Department department, Set<Course> course) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.headDepartment = headDepartment;
        this.department = department;
        this.course = course;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getHeadDepartment() {
        return headDepartment;
    }

    public void setHeadDepartment(Department headDepartment) {
        this.headDepartment = headDepartment;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Course> getCourse() {
        return course;
    }

    public void setCourse(Set<Course> course) {
        this.course = course;
    }

    

}
