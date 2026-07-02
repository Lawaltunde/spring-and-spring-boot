package com.amigoscode.student;

// TODO: 3 - Create a repository interface for the Student entity
//  This interface should extend JpaRepository<Student, Long>

// TODO: 5 - Add derived query methods:
//  - findByEmail(String email) — returns Optional<Student>
//  - findByFirstNameAndLastName(String firstName, String lastName) — returns List<Student>

// TODO: 6 - Add more derived query methods:
//  - findByAgeBetween(int min, int max) — returns List<Student>
//  - findByLastNameContaining(String name) — returns List<Student>
//  - findByAgeGreaterThan(int age) — returns List<Student>

// TODO: 7 - Add a JPQL query to find students by email domain:
//  @Query("SELECT s FROM Student s WHERE s.email LIKE %:domain")
//  List<Student> findByEmailDomain(@Param("domain") String domain);

// TODO: 8 - Add a native query to find the oldest student:
//  @Query(value = "SELECT * FROM students ORDER BY age DESC LIMIT 1", nativeQuery = true)
//  Student findOldestStudent();

// TODO: 9 - Add an update query to change a student's email:
//  @Modifying
//  @Transactional
//  @Query("UPDATE Student s SET s.email = :email WHERE s.id = :id")
//  void updateEmailById(@Param("id") Long id, @Param("email") String email);
