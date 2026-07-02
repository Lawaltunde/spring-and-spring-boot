# Amigoscode Spring Boot Exercises

Guided hands-on exercises for the Spring Boot learning path on
[Amigoscode Academy](https://skool.com/amigoscode).

## Tech Stack

- Java 25
- Spring Boot 4
- H2 In-Memory Database
- Maven

## Courses

This repository contains exercises for the following courses:

| # | Branch | Course | Exercises |
|---|--------|--------|-----------|
| 1 | `spring-framework-exercises` | Spring Framework | 5 |
| 2 | `spring-boot-exercises` | Spring Boot | 6 |
| 3 | `building-apis-with-spring-boot-exercises` | Building APIs with Spring Boot | 20 |
| 4 | `advanced-spring-boot-exercises` | Advanced Spring Boot | 20 |
| 5 | `spring-data-jpa-exercises` | Spring Data JPA | 25 |

Each course has a matching `-solutions` branch with completed code.

## How to Use

1. Pick a course and checkout the exercises branch:
   ```bash
   git checkout spring-boot-exercises
   ```
2. Open the project in IntelliJ IDEA
3. Follow the exercises in the **README.md** on each branch — they are listed in order with the file to edit and what to do
4. Use the **TODO tool window** (`View > Tool Windows > TODO`) to jump to exercise locations in the code
5. Stuck? Check the solutions branch:
   ```bash
   git checkout spring-boot-solutions
   ```

## Prerequisites

**Java 25 is required.** This project will not compile with older Java versions. Make sure you have Java 25 installed before starting.

You can check your Java version with:
```bash
java -version
```

Each course builds on the previous. We recommend this order:

1. Spring Framework
2. Spring Boot
3. Building APIs with Spring Boot
4. Advanced Spring Boot
5. Spring Data JPA

## Exercise Breakdown

<details>
<summary><strong>Spring Framework (5 exercises)</strong></summary>

| # | Topic | File |
|---|-------|------|
| 01 | Create a bean with `@Component` | `greeting/GreetingService.java` |
| 02 | Constructor injection | `greeting/GreetingController.java` |
| 03 | Define a bean with `@Bean` and `@Qualifier` | `greeting/GreetingConfig.java` |
| 04 | Lifecycle hooks (`@PostConstruct`, `@PreDestroy`) | `greeting/GreetingService.java` |
| 05 | Stereotype annotations and wiring | `user/UserRepository.java`, `user/UserService.java` |

</details>

<details>
<summary><strong>Spring Boot (6 exercises)</strong></summary>

| # | Topic | File |
|---|-------|------|
| 01 | Define the `Book` entity | `book/Book.java` |
| 02 | Create `BookRepository` | `book/BookRepository.java` |
| 03 | GET all books | `book/BookController.java` |
| 04 | GET book by ID | `book/BookController.java` |
| 05 | POST a new book | `book/BookController.java` |
| 06 | DELETE a book by ID | `book/BookController.java` |

</details>

<details>
<summary><strong>Building APIs with Spring Boot (20 exercises)</strong></summary>

| # | Topic | File |
|---|-------|------|
| 01 | Create your first endpoint | `order/OrderController.java` |
| 02 | Return an object | `order/OrderController.java` |
| 03 | Return a list of orders | `order/OrderController.java` |
| 04 | `@PathVariable` | `order/OrderController.java` |
| 05 | `@RequestParam` | `order/OrderController.java` |
| 06 | `@PostMapping` | `order/OrderController.java` |
| 07 | `@PutMapping` | `order/OrderController.java` |
| 08 | `@DeleteMapping` | `order/OrderController.java` |
| 09 | `@RequestMapping` at class level | `order/OrderController.java` |
| 10 | `ResponseEntity` with status codes | `order/OrderController.java` |
| 11 | Create the `OrderService` | `order/OrderService.java` |
| 12 | Create the `OrderRepository` | `order/OrderRepository.java` |
| 13 | Wire layers with constructor injection | `order/OrderController.java` |
| 14 | `@JsonProperty` to rename a field | `order/Order.java` |
| 15 | `@JsonIgnore` to hide a field | `order/Order.java` |
| 16 | `@JsonFormat` and `@JsonInclude` | `order/Order.java` |
| 17 | Implement a logging filter | `filter/LoggingFilter.java` |
| 18 | Functional endpoint with `RouterFunction` | `config/RouterConfig.java` |
| 19 | Change embedded server to Jetty | `pom.xml` |
| 20 | Configure server properties | `application.yml` |

</details>

<details>
<summary><strong>Advanced Spring Boot (20 exercises)</strong></summary>

| # | Topic | File |
|---|-------|------|
| 01 | Validation annotations (`@NotBlank`, `@Positive`) | `order/dto/CreateOrderRequest.java` |
| 02 | Trigger validation with `@Valid` | `order/OrderController.java` |
| 03 | `@Email` and `@Size` validation | `order/dto/CreateOrderRequest.java` |
| 04 | Custom validator (`@ValidOrderStatus`) | `order/validation/` |
| 05 | `@ResponseStatus` exception | `order/exception/OrderNotFoundException.java` |
| 06 | Structured error response (`ApiError`) | `order/exception/ApiError.java` |
| 07 | `@ControllerAdvice` global handler | `order/exception/GlobalExceptionHandler.java` |
| 08 | Handle validation errors globally | `order/exception/GlobalExceptionHandler.java` |
| 09 | Convert Order to JPA entity | `order/Order.java` |
| 10 | Replace repository with `JpaRepository` | `order/OrderRepository.java` |
| 11 | Derived query methods | `order/OrderRepository.java` |
| 12 | Custom `@Query` | `order/OrderRepository.java` |
| 13 | Seed database with `data.sql` | `data.sql` |
| 14 | Build a REST client | `post/` |
| 15 | `@Value` property injection | `order/OrderController.java` |
| 16 | Spring profiles | `application-dev.yml` |
| 17 | Replace `System.out.println` with Logger | `order/OrderController.java` |
| 18 | Spring Actuator | `application.yml` |
| 19 | Spring Security with Basic Auth | `security/SecurityConfig.java` |
| 20 | In-memory user with `BCryptPasswordEncoder` | `security/SecurityConfig.java` |

</details>

<details>
<summary><strong>Spring Data JPA (25 exercises)</strong></summary>

| # | Topic | File |
|---|-------|------|
| 01 | `@Entity` and `@Id` | `student/Student.java` |
| 02 | `@Column` and `@Table` constraints | `student/Student.java` |
| 03 | Create `StudentRepository` | `student/StudentRepository.java` |
| 04 | Save students and print count | `DataInitializer.java` |
| 05 | Derived queries (`findByEmail`, `findByFirstNameAndLastName`) | `student/StudentRepository.java` |
| 06 | More derived queries (`Between`, `Containing`, `GreaterThan`) | `student/StudentRepository.java` |
| 07 | JPQL query with `@Query` | `student/StudentRepository.java` |
| 08 | Native SQL query | `student/StudentRepository.java` |
| 09 | `@Modifying` and `@Transactional` update query | `student/StudentRepository.java` |
| 10 | Sorting with `Sort.by(...)` | `student/StudentController.java` |
| 11 | Pagination with `Pageable` | `student/StudentController.java` |
| 12 | `@OneToOne` with `@JoinColumn` | `card/StudentIdCard.java` |
| 13 | Cascade and fetch type | `card/StudentIdCard.java` |
| 14 | Bidirectional one-to-one (`mappedBy`) | `student/Student.java` |
| 15 | `@OneToMany` relationship with Book | `student/Student.java` |
| 16 | Bidirectional one-to-many (`@ManyToOne`) | `book/Book.java` |
| 17 | Add/remove helper methods for Book | `student/Student.java` |
| 18 | `@ManyToMany` with `@JoinTable` | `student/Student.java`, `course/Course.java` |
| 19 | Add/remove helpers for Course | `student/Student.java` |
| 20 | Soft delete (`@SQLDelete`, `@SQLRestriction`) | `student/Student.java` |
| 21 | Auditing (`@CreatedDate`, `@LastModifiedDate`) | `student/Student.java` |
| 22 | `AuditorAware` and `@EnableJpaAuditing` | `config/AuditingConfig.java` |
| 23 | DTO projection | `student/StudentDTO.java`, `student/StudentController.java` |
| 24 | `@Transactional` transfer | `account/AccountService.java` |
| 25 | Test transaction rollback | `account/AccountService.java` |

</details>

## Community

Join the [Amigoscode Academy](https://skool.com/amigoscode) to get help,
share your progress, and connect with other learners.
