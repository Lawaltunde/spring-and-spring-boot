# Spring Boot - Exercises

Hands-on exercises for the **Spring Boot** course on
[Amigoscode Academy](https://skool.com/amigoscode).

## What You'll Practice

- Defining JPA entities
- Creating repositories
- Building CRUD REST endpoints (GET, POST, DELETE)

## Getting Started

1. Open the project in IntelliJ IDEA
2. Open the TODO tool window: **View > Tool Windows > TODO**
3. Follow the exercises below in order
4. Access H2 console at: http://localhost:8080/h2-console

## Exercises

### TODO: 01 - Define the Book entity
**File:** `book/Book.java`

Make this class a JPA entity:
- Add `@Entity` annotation to the class
- Add `@Id` and `@GeneratedValue(strategy = GenerationType.IDENTITY)` to the `id` field
- Add a no-arg constructor (required by JPA)

---

### TODO: 02 - Create BookRepository
**File:** `book/BookRepository.java`

Create an interface that extends `JpaRepository<Book, Long>`. You don't need to add any methods — `JpaRepository` provides them all.

---

### TODO: 03 - GET all books
**File:** `book/BookController.java`

Inject `BookRepository` via constructor injection. Create a `@GetMapping` endpoint mapped to `"/api/v1/books"` that returns `bookRepository.findAll()`.

---

### TODO: 04 - GET book by ID
**File:** `book/BookController.java`

Create a `@GetMapping` endpoint mapped to `"/api/v1/books/{id}"`. Use `@PathVariable Long id` and `bookRepository.findById(id)`. Return 404 if the book is not found.

---

### TODO: 05 - POST a new book
**File:** `book/BookController.java`

Create a `@PostMapping` endpoint mapped to `"/api/v1/books"`. Accept a `@RequestBody Book` and save it with `bookRepository.save(book)`.

---

### TODO: 06 - DELETE a book by ID
**File:** `book/BookController.java`

Create a `@DeleteMapping` endpoint mapped to `"/api/v1/books/{id}"`. Use `@PathVariable Long id` and `bookRepository.deleteById(id)`.

## Solutions

```bash
git checkout spring-boot-solutions
```

## Community

Join the [Amigoscode Academy](https://skool.com/amigoscode) to get help and share your progress.
