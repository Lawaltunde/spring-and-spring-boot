# Building APIs with Spring Boot - Exercises

Hands-on exercises for the **Building APIs with Spring Boot** course on
[Amigoscode Academy](https://skool.com/amigoscode).

## What You'll Practice

- Building REST endpoints with Spring MVC
- Path variables, query parameters, and request bodies
- ResponseEntity and HTTP status codes
- N-Tier architecture (Controller > Service > Repository)
- JSON serialization with Jackson
- Filters and functional endpoints
- Embedded web server configuration

## Reference Code

The `Customer` domain (`CustomerController`, `CustomerService`, `CustomerRepository`) is fully implemented as a working reference. Use it as a guide when building the `Order` domain.

## Getting Started

1. Open the project in IntelliJ IDEA
2. Open the TODO tool window: **View > Tool Windows > TODO**
3. Follow the exercises below in order

## Exercises

### TODO: 01 - Create your first endpoint
**File:** `order/OrderController.java`

Add a `@GetMapping("/api/v1/orders/welcome")` that returns the string `"Welcome to the Orders API"`.

---

### TODO: 02 - Return an object
**File:** `order/OrderController.java`

Add a `@GetMapping("/api/v1/orders/sample")` that returns a hardcoded `Order` object.

Hint: `new Order(1L, "Laptop", "PENDING", 999.99, "john@mail.com", LocalDate.now(), "rush")`

---

### TODO: 03 - Return a list of orders
**File:** `order/OrderController.java`

Add a `@GetMapping("/api/v1/orders")` that returns a hardcoded `List<Order>`.

---

### TODO: 04 - Use @PathVariable
**File:** `order/OrderController.java`

Add a `@GetMapping("/api/v1/orders/{id}")` with `@PathVariable Long id`. Return a hardcoded Order with the given id.

---

### TODO: 05 - Use @RequestParam
**File:** `order/OrderController.java`

Add a `@GetMapping("/api/v1/orders/filter")` with `@RequestParam(required = false) String status`. Return filtered orders if status is provided, otherwise return all.

---

### TODO: 06 - Create a @PostMapping
**File:** `order/OrderController.java`

Add a `@PostMapping("/api/v1/orders")` with `@RequestBody Order`. Return the received order.

---

### TODO: 07 - Create a @PutMapping
**File:** `order/OrderController.java`

Add a `@PutMapping("/api/v1/orders/{id}")` with `@PathVariable Long id` and `@RequestBody Order`.

---

### TODO: 08 - Create a @DeleteMapping
**File:** `order/OrderController.java`

Add a `@DeleteMapping("/api/v1/orders/{id}")` with `@PathVariable Long id`.

---

### TODO: 09 - Use @RequestMapping at class level
**File:** `order/OrderController.java`

Add `@RequestMapping("/api/v1/orders")` to the class. Simplify all endpoint paths by removing the `"/api/v1/orders"` prefix.

---

### TODO: 10 - Return ResponseEntity with proper status codes
**File:** `order/OrderController.java`

Refactor all endpoints to return `ResponseEntity<>`:
- GET returns `200 OK`
- POST returns `201 Created`
- PUT returns `204 No Content`
- DELETE returns `204 No Content` or `404 Not Found`

Hint: look at `CustomerController` for reference.

---

### TODO: 11 - Create the OrderService
**File:** `order/OrderService.java`

- Annotate with `@Service`
- Inject `OrderRepository` via constructor injection
- Add methods: `getAllOrders()`, `getOrderById()`, `getOrdersByStatus()`, `createOrder()`, `updateOrder()`, `deleteOrder()`

Hint: look at `CustomerService` for reference.

---

### TODO: 12 - Create the OrderRepository
**File:** `order/OrderRepository.java`

- Annotate with `@Repository`
- Use an `ArrayList<Order>` initialized with sample data
- Add methods: `findAll()`, `findById()`, `findByStatus()`, `save()`, `update()`, `deleteById()`

Hint: look at `CustomerRepository` for reference.

---

### TODO: 13 - Wire layers with constructor injection
**File:** `order/OrderController.java`

Inject `OrderService` via constructor. Replace direct data access with service method calls.

---

### TODO: 14 - Use @JsonProperty to rename a field
**File:** `order/Order.java`

Add `@JsonProperty("order_date")` to the `orderDate` field so it appears as `"order_date"` in JSON.

Hint: look at how `Customer` uses `@JsonProperty`.

---

### TODO: 15 - Use @JsonIgnore to hide a field
**File:** `order/Order.java`

Add `@JsonIgnore` to the `internalNotes` field so it is hidden from JSON responses.

Hint: look at how `Customer` uses `@JsonIgnore`.

---

### TODO: 16 - Customize JSON serialization
**File:** `order/Order.java`

- Add `@JsonFormat(pattern = "dd-MM-yyyy")` to `orderDate`
- Add `@JsonInclude(JsonInclude.Include.NON_NULL)` to the class

---

### TODO: 17 - Implement a logging filter
**File:** `filter/LoggingFilter.java`

- Add `@Component` and implement `Filter` (`jakarta.servlet.Filter`)
- In `doFilter()`: log `req.getMethod() + " " + req.getRequestURI()` before `chain.doFilter()`
- Log `res.getStatus()` after `chain.doFilter()`

---

### TODO: 18 - Create a functional endpoint
**File:** `config/RouterConfig.java`

- Add `@Configuration`
- Create a `@Bean` returning `RouterFunction<ServerResponse>`
- Define `GET "/api/v1/orders/summary"` returning a `Map` with `"totalOrders"` and `"pendingOrders"`

---

### TODO: 19 - Change embedded server to Jetty
**File:** `pom.xml`

- Exclude `spring-boot-starter-tomcat` from `spring-boot-starter-web`
- Add `spring-boot-starter-jetty` dependency

---

### TODO: 20 - Configure server properties
**File:** `src/main/resources/application.yml`

```yaml
server:
  port: 9090
  servlet:
    context-path: /amigoscode
  jetty:
    connection-idle-timeout: 30s
```

After this change, your API will be at: `http://localhost:9090/amigoscode/api/v1/orders`

## Solutions

```bash
git checkout building-apis-with-spring-boot-solutions
```

## Community

Join the [Amigoscode Academy](https://skool.com/amigoscode) to get help and share your progress.
