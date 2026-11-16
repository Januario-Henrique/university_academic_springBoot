package com.auca.university_academic_springBoot.model;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.*;

@Entity 
@Table(name = "department")
public class Department {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name", nullable = false, unique = true)
    private String name;
    @Column (name = "code", nullable = false, unique = true)
    private String code;

    @OneToOne 
    @JoinColumn (name = "head_lecturer_id", nullable = false, unique = true)
    private Lecturer head;

    @OneToMany (mappedBy = "department")
    private List<Lecturer> lecturers = new ArrayList<>();

    @OneToMany (mappedBy = "department")
    private List<Course> courses = new ArrayList<>();

    @OneToMany (mappedBy = "department")
    private List<Student> students = new ArrayList<>();

    public Department() {
    }

    public Department(Long id, String name, String code, Lecturer head, List<Lecturer> lecturers, List<Course> courses,
            List<Student> students) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.head = head;
        this.lecturers = lecturers;
        this.courses = courses;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Lecturer getHead() {
        return head;
    }

    public void setHead(Lecturer head) {
        this.head = head;
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    

}
