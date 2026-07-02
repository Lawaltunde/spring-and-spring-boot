package com.amigoscode.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    // Inject StudentRepository via constructor injection

    // TODO: 10 - Add an endpoint GET /api/v1/students/sorted
    //  that returns all students sorted by lastName then firstName
    //  Hint: use Sort.by("lastName").ascending().and(Sort.by("firstName").ascending())

    // TODO: 11 - Add an endpoint GET /api/v1/students/paged?page=0&size=5
    //  that returns a Page<Student>
    //  Hint: accept Pageable as a method parameter — Spring will bind page and size automatically

    // TODO: 23 - Add an endpoint GET /api/v1/students/dto
    //  that returns List<StudentDTO> instead of List<Student>
    //  Map each Student to a new StudentDTO(fullName, email)
    //  where fullName = firstName + " " + lastName

}
