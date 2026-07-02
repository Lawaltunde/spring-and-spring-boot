package com.amigoscode.student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// TODO: 1 - Make this class a JPA entity by:
//  - Adding @Entity annotation
//  - Adding @Id annotation to the id field
//  - Adding @GeneratedValue with a @SequenceGenerator:
//    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")

// TODO: 2 - Add the following column and table constraints:
//  - @Table(name = "students")
//  - @Column(name = "first_name", nullable = false, length = 100) on firstName
//  - @Column(name = "last_name", nullable = false, length = 100) on lastName
//  - @Column(nullable = false, unique = true) on email
//  - @Column(nullable = false) on age

// TODO: 20 - Add soft delete support:
//  - Add a field: private boolean active = true;
//  - Add @SQLDelete(sql = "UPDATE students SET active = false WHERE id = ?") on the class
//  - Add @SQLRestriction("active = true") on the class

// TODO: 21 - Add auditing annotations:
//  - Add @CreatedDate on a new field: private LocalDateTime createdAt
//  - Add @LastModifiedDate on a new field: private LocalDateTime updatedAt
//  - Add @Column(nullable = false, updatable = false) on createdAt
//  - Add @EntityListeners(AuditingEntityListener.class) on the class
public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    // TODO: 14 - Add bidirectional one-to-one with StudentIdCard:
    //  private StudentIdCard studentIdCard;
    //  @OneToOne(mappedBy = "student", orphanRemoval = true)

    // TODO: 15 - Add one-to-many relationship with Book:
    //  private List<Book> books = new ArrayList<>();
    //  @OneToMany

    // TODO: 18 - Add many-to-many relationship with Course:
    //  private Set<Course> courses = new HashSet<>();
    //  @ManyToMany
    //  @JoinTable(
    //      name = "student_course",
    //      joinColumns = @JoinColumn(name = "student_id"),
    //      inverseJoinColumns = @JoinColumn(name = "course_id")
    //  )

    public Student() {
    }

    public Student(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    // TODO: 17 - Add helper methods for Book:
    //  public void addBook(Book book) — adds the book and sets book.setStudent(this)
    //  public void removeBook(Book book) — removes the book and sets book.setStudent(null)

    // TODO: 19 - Add helper methods for Course:
    //  public void enrollInCourse(Course course) — adds course to this.courses and adds this to course.getStudents()
    //  public void dropCourse(Course course) — removes course from this.courses and removes this from course.getStudents()

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
