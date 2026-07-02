# Spring Framework - Exercises

Hands-on exercises for the **Spring Framework** course on
[Amigoscode Academy](https://skool.com/amigoscode).

## What You'll Practice

- Dependency Injection and Inversion of Control
- Creating beans with `@Component` and `@Bean`
- Constructor injection
- Bean lifecycle hooks (`@PostConstruct`, `@PreDestroy`)
- Stereotype annotations (`@Service`, `@Repository`)

## Getting Started

1. Open the project in IntelliJ IDEA
2. Open the TODO tool window: **View > Tool Windows > TODO**
3. Follow the exercises below in order

## Exercises

### TODO: 01 - Create a bean with `@Component`
**File:** `greeting/GreetingService.java`

Annotate `GreetingService` with `@Component` so Spring manages it as a bean.

---

### TODO: 02 - Inject GreetingService using constructor injection
**File:** `greeting/GreetingController.java`

Add a `private final GreetingService` field and inject it via the constructor. Use it in the `greet()` method to return `greetingService.greet(name)`.

---

### TODO: 03 - Define a String bean with `@Bean` and `@Qualifier`
**File:** `greeting/GreetingConfig.java`

Create a `@Bean("greetingMessage")` method that returns `"Hello"`. Then in `GreetingService`, add `@Qualifier("greetingMessage")` to the `String` constructor parameter.

---

### TODO: 04 - Add lifecycle hooks
**File:** `greeting/GreetingService.java`

Add a method annotated with `@PostConstruct` that prints `"GreetingService has been initialized"`. Add a method annotated with `@PreDestroy` that prints `"GreetingService is being destroyed"`.

---

### TODO: 05 - Use stereotype annotations and wiring
**Files:** `user/UserRepository.java` and `user/UserService.java`

- Annotate `UserRepository` with `@Repository`
- Annotate `UserService` with `@Service`
- Inject `UserRepository` into `UserService` via constructor injection
- Use the injected repository in `getAllUsers()` to return `userRepository.findAllUsers()`

## Solutions

```bash
git checkout spring-framework-solutions
```

## Community

Join the [Amigoscode Academy](https://skool.com/amigoscode) to get help and share your progress.
