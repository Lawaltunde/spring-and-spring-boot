package com.amigoscode.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findByAgeBetween(int min, int max);

    List<Student> findByLastNameContaining(String name);

    List<Student> findByAgeGreaterThan(int age);

    @Query("SELECT s FROM Student s WHERE s.email LIKE %:domain")
    List<Student> findByEmailDomain(@Param("domain") String domain);

    @Query(value = "SELECT * FROM students ORDER BY age DESC LIMIT 1", nativeQuery = true)
    Student findOldestStudent();

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.email = :email WHERE s.id = :id")
    void updateEmailById(@Param("id") Long id, @Param("email") String email);

}
