package com.amigoscode.course;

import com.amigoscode.student.Student;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // TODO: 18 - Add the other side of the many-to-many relationship:
    //  private Set<Student> students = new HashSet<>();
    //  @ManyToMany(mappedBy = "courses")

    public Course() {
    }

    public Course(String name) {
        this.name = name;
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

    // TODO: 18 - Add getter for students

}
