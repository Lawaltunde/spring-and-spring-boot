package com.amigoscode.book;

import com.amigoscode.student.Student;
import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    // TODO: 16 - Add bidirectional many-to-one relationship:
    //  - Add a Student field named "student"
    //  - Annotate with @ManyToOne
    //  - Add @JoinColumn(name = "student_id")

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // TODO: 16 - Add getter and setter for student

}
