# Spring Data JPA - Exercises

Hands-on exercises for the **Spring Data JPA** course on
[Amigoscode Academy](https://skool.com/amigoscode).

## What You'\''ll Practice

- Entities, columns, and table mappings
- Repositories and CRUD operations
- Derived queries, JPQL, and native queries
- Sorting and pagination
- One-to-One, One-to-Many, Many-to-Many relationships
- Cascade types, fetch strategies, and bidirectional mappings
- Soft delete
- Auditing
- DTOs and projections
- Database transactions

## Getting Started

1. Open the project in IntelliJ IDEA
2. Open the TODO tool window: **View > Tool Windows > TODO**
3. Follow the exercises below in order
4. Access H2 console at: http://localhost:8080/h2-console

## Exercises

### TODO: 01 - Make Student a JPA entity
**File:** `student/Student.java`

- Add `@Entity` annotation
- Add `@Id` to the id field
- Add `@SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)`
- Add `@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")`

---

### TODO: 02 - Add column and table constraints
**File:** `student/Student.java`

- Add `@Table(name = "students")`
- Add `@Column(name = "first_name", nullable = false, length = 100)` on firstName
- Add `@Column(name = "last_name", nullable = false, length = 100)` on lastName
- Add `@Column(nullable = false, unique = true)` on email
- Add `@Column(nullable = false)` on age

---

### TODO: 03 - Create StudentRepository
**File:** `student/StudentRepository.java`

Create an interface extending `JpaRepository<Student, Long>`.

---

### TODO: 04 - Save students and print count
**File:** `DataInitializer.java`

Inject `StudentRepository` via constructor. Save 3 students:
- `new Student("John", "Doe", "john@gmail.com", 25)`
- `new Student("Jane", "Smith", "jane@yahoo.com", 22)`
- `new Student("Bob", "Johnson", "bob@gmail.com", 30)`

Print the count using `studentRepository.count()`.

---

### TODO: 05 - Add derived query methods
**File:** `student/StudentRepository.java`

- `Optional<Student> findByEmail(String email)`
- `List<Student> findByFirstNameAndLastName(String firstName, String lastName)`

---

### TODO: 06 - Add more derived query methods
**File:** `student/StudentRepository.java`

- `List<Student> findByAgeBetween(int min, int max)`
- `List<Student> findByLastNameContaining(String name)`
- `List<Student> findByAgeGreaterThan(int age)`

---

### TODO: 07 - Add a JPQL query
**File:** `student/StudentRepository.java`

```java
@Query("SELECT s FROM Student s WHERE s.email LIKE %:domain")
List<Student> findByEmailDomain(@Param("domain") String domain);
```

---

### TODO: 08 - Add a native query
**File:** `student/StudentRepository.java`

```java
@Query(value = "SELECT * FROM students ORDER BY age DESC LIMIT 1", nativeQuery = true)
Student findOldestStudent();
```

---

### TODO: 09 - Add a modifying query
**File:** `student/StudentRepository.java`

```java
@Modifying
@Transactional
@Query("UPDATE Student s SET s.email = :email WHERE s.id = :id")
void updateEmailById(@Param("id") Long id, @Param("email") String email);
```

---

### TODO: 10 - Add a sorted endpoint
**File:** `student/StudentController.java`

Inject `StudentRepository` via constructor. Add `GET /api/v1/students/sorted` that returns students sorted by lastName then firstName.

Hint: `Sort.by("lastName").ascending().and(Sort.by("firstName").ascending())`

---

### TODO: 11 - Add a paginated endpoint
**File:** `student/StudentController.java`

Add `GET /api/v1/students/paged?page=0&size=5`. Accept `Pageable` as a method parameter and return `studentRepository.findAll(pageable)`.

---

### TODO: 12 - Create StudentIdCard with @OneToOne
**File:** `card/StudentIdCard.java`

- Add `@Entity`, `@Id`, `@GeneratedValue(strategy = GenerationType.IDENTITY)`
- Add `@OneToOne` on the student field
- Add `@JoinColumn(name = "student_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "student_id_card_student_fk"))`

---

### TODO: 13 - Configure cascade and fetch type
**File:** `card/StudentIdCard.java`

Update `@OneToOne` to include `cascade = CascadeType.ALL` and `fetch = FetchType.LAZY`.

---

### TODO: 14 - Make one-to-one bidirectional
**File:** `student/Student.java`

Add a `StudentIdCard` field with `@OneToOne(mappedBy = "student", orphanRemoval = true)`.

---

### TODO: 15 - Add one-to-many with Book
**File:** `student/Student.java`

Add `@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)` on a `List<Book> books = new ArrayList<>()` field.

---

### TODO: 16 - Make one-to-many bidirectional
**File:** `book/Book.java`

Add a `Student` field with `@ManyToOne` and `@JoinColumn(name = "student_id")`. Add getter and setter.

---

### TODO: 17 - Add helper methods for Book
**File:** `student/Student.java`

- `addBook(Book book)` — adds the book and sets `book.setStudent(this)`
- `removeBook(Book book)` — removes the book and sets `book.setStudent(null)`

---

### TODO: 18 - Add many-to-many with Course
**Files:** `student/Student.java` and `course/Course.java`

In Student:
```java
@ManyToMany
@JoinTable(
    name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id")
)
private Set<Course> courses = new HashSet<>();
```

In Course: add `@ManyToMany(mappedBy = "courses")` on a `Set<Student>` field.

---

### TODO: 19 - Add helper methods for Course
**File:** `student/Student.java`

- `enrollInCourse(Course course)` — adds course to `this.courses` and adds `this` to `course.getStudents()`
- `dropCourse(Course course)` — removes from both sides

---

### TODO: 20 - Add soft delete
**File:** `student/Student.java`

- Add `private boolean active = true`
- Add `@SQLDelete(sql = "UPDATE students SET active = false WHERE id = ?")`
- Add `@SQLRestriction("active = true")`

---

### TODO: 21 - Add auditing annotations
**File:** `student/Student.java`

- Add `@EntityListeners(AuditingEntityListener.class)` on the class
- Add `@CreatedDate` on `private LocalDateTime createdAt` with `@Column(nullable = false, updatable = false)`
- Add `@LastModifiedDate` on `private LocalDateTime updatedAt`

---

### TODO: 22 - Enable JPA Auditing and AuditorAware
**File:** `config/AuditingConfig.java`

- Add `@Configuration` and `@EnableJpaAuditing`
- Create a `@Bean` returning `AuditorAware<String>`: `() -> Optional.of("system")`
- Then in Student, add `@CreatedBy` and `@LastModifiedBy` on new `String` fields

---

### TODO: 23 - Create StudentDTO and projection endpoint
**Files:** `student/StudentDTO.java` and `student/StudentController.java`

Create `public record StudentDTO(String fullName, String email)`.

Add `GET /api/v1/students/dto` that maps each Student to `new StudentDTO(firstName + " " + lastName, email)`.

---

### TODO: 24 - Implement transactional transfer
**File:** `account/AccountService.java`

Annotate `transfer()` with `@Transactional`. Find both accounts by ID, check balance, debit sender, credit receiver, save both.

---

### TODO: 25 - Test transaction rollback
**File:** `account/AccountService.java`

Create `transferWithBug()` — same as transfer but throw `RuntimeException` after debiting the sender and before crediting the receiver. `@Transactional` should rollback automatically.

## Solutions

```bash
git checkout spring-data-jpa-solutions
```

## Community

Join the [Amigoscode Academy](https://skool.com/amigoscode) to get help and share your progress.
