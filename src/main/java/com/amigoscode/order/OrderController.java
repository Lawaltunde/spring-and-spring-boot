package com.amigoscode.order;

import com.amigoscode.order.dto.CreateOrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Orders API";
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Order>> getOrdersByStatus(
            @RequestParam(required = false) String status) {
        if (status != null) {
            return ResponseEntity.ok(orderService.getOrdersByStatus(status));
        }
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // TODO: 2 - Add @Valid annotation before the @RequestBody parameter
    //  to trigger bean validation on CreateOrderRequest
    //  Hint: import jakarta.validation.Valid
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequest request) {
        Order order = new Order();
        order.setDescription(request.getDescription());
        order.setStatus(request.getStatus());
        order.setTotalAmount(request.getTotalAmount());
        order.setCustomerEmail(request.getCustomerEmail());
        order.setOrderDate(LocalDate.now());
        Order created = orderService.createOrder(order);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOrder(
            @PathVariable Long id,
            @RequestBody Order order) {
        order.setId(id);
        orderService.updateOrder(order);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        boolean deleted = orderService.deleteOrder(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // TODO: 15 - Inject the property app.order.max-items using @Value
    //  Create a GET endpoint "/api/v1/orders/max-items" that returns the value
    //  Hint: @Value("${app.order.max-items}")

    // TODO: 17 - Replace all System.out.println statements in this class with Logger
    //  private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    //  Use log.info() for normal operations, log.warn() for not found, log.error() for failures

}
