package com.amigoscode.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/sorted")
    public List<Student> getAllStudentsSorted() {
        return studentRepository.findAll(
                Sort.by("lastName").ascending()
                        .and(Sort.by("firstName").ascending())
        );
    }

    @GetMapping("/paged")
    public Page<Student> getAllStudentsPaged(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @GetMapping("/dto")
    public List<StudentDTO> getAllStudentsAsDto() {
        return studentRepository.findAll()
                .stream()
                .map(s -> new StudentDTO(
                        s.getFirstName() + " " + s.getLastName(),
                        s.getEmail()
                ))
                .toList();
    }

}
