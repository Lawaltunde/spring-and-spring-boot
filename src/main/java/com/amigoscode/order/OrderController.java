package com.amigoscode.order;

import com.amigoscode.order.dto.CreateOrderRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    @Value("${app.order.max-items}")
    private int maxItems;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Orders API";
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        log.info("GET /api/v1/orders");
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        log.info("GET /api/v1/orders/{}", id);
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Order>> getOrdersByStatus(
            @RequestParam(required = false) String status) {
        if (status != null) {
            return ResponseEntity.ok(orderService.getOrdersByStatus(status));
        }
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/max-items")
    public int getMaxItems() {
        return maxItems;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody CreateOrderRequest request) {
        log.info("POST /api/v1/orders");
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

}
